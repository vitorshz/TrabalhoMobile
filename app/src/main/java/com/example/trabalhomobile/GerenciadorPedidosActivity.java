package com.example.trabalhomobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trabalhomobile.modelos.Cliente;
import com.example.trabalhomobile.modelos.GerenciadorPedidos;
import com.example.trabalhomobile.modelos.Item;
import com.example.trabalhomobile.modelos.ItemVenda;
import com.example.trabalhomobile.modelos.Pedido;

import java.util.ArrayList;

public class GerenciadorPedidosActivity extends AppCompatActivity {
    private EditText edIdPedido;
    private Button btAddPedido;
    private TextView tvListaPedido;
    private TextView tvListaPedidoRecentes;
    private ArrayList<Pedido> listaPedidos;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Item> listaItens;
    private ArrayList<ItemVenda> listaItenVenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerenciador_pedidos);
        setTitle("Pesquisa de Pedidos");

        edIdPedido = findViewById(R.id.edIdPedido);
        btAddPedido = findViewById(R.id.btAddPedido);
        tvListaPedido = findViewById(R.id.tvListaPedido);
        tvListaPedidoRecentes = findViewById(R.id.tvListaPedidoRecentes);

        carregarClientes();
        carregarItens();
        carregarItensVenda();
        carregarPedidos();
        carregarPedidosRecentes();
        btAddPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pesquisarPedido();
            }
        });
    }

    private void pesquisarPedido() {
        String idPedidoText = edIdPedido.getText().toString().trim();

        if (!idPedidoText.isEmpty()) {
            try {
                int idPedido = Integer.parseInt(idPedidoText);
                Pedido pedidoEncontrado = buscarPedidoPorId(idPedido);

                if (pedidoEncontrado != null) {
                    String texto = "ID: " + pedidoEncontrado.getId() + "\nCliente: "
                            + pedidoEncontrado.getCliente().getNome()
                            + "\nValor Total: " + pedidoEncontrado.getValorTotal() + "\nItens do Pedido:\n";

                    for (ItemVenda itemVenda : pedidoEncontrado.getListaItemVenda()) {
                        texto += "  - Descrição: " + itemVenda.getItem().getDescricao() + "\n     Subtotal: " + itemVenda.getSubtotal() + "\n";
                    }

                    tvListaPedido.setText(texto);
                } else {
                    Toast.makeText(this, "Pedido não encontrado", Toast.LENGTH_SHORT).show();
                }
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Digite um ID de pedido válido", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Digite um ID de pedido válido", Toast.LENGTH_SHORT).show();
        }
    }

    public Pedido buscarPedidoPorId(int idPedido) {
        for (Pedido pedido : listaPedidos) {
            if (pedido.getId() == idPedido) {
                return pedido;
            }
        }
        return null;
    }

    private void carregarItensVenda() {
        listaItenVenda = Controller.getInstance().retornarItensVenda();
        String[] vetItens = new String[listaItenVenda.size() + 1];
        vetItens[0] = "Selecione o Item";
        for (int i = 0; i < listaItenVenda.size(); i++) {
            ItemVenda item = listaItenVenda.get(i);
            vetItens[i + 1] = item.getItem() + " R$ " + item.getSubtotal();
        }
    }

    private void carregarClientes() {
        listaClientes = Controller.getInstance().retornarClientes();
        String[] vetCliente = new String[listaClientes.size()];
        for (int i = 0; i < listaClientes.size(); i++) {
            Cliente cliente = listaClientes.get(i);
            vetCliente[i] = cliente.getNome();
        }

    }

    private void carregarItens() {
        listaItens = Controller.getInstance().retornarItem();
        String[] vetItens = new String[listaItens.size() + 1];
        vetItens[0] = "Selecione o Item";
        for (int i = 0; i < listaItens.size(); i++) {
            Item item = listaItens.get(i);
            vetItens[i + 1] = item.getDescricao() + " R$ " + item.getValorUnit();
        }

    }

    private void carregarPedidos() {
        listaPedidos = Controller.getInstance().retornarPedidos();
        String[] vetPed = new String[listaPedidos.size() + 1];
        vetPed[0] = "Selecione o professor";
        for (int i = 0; i < listaPedidos.size(); i++) {
            Pedido pedido = listaPedidos.get(i);
            vetPed[i + 1] = " ID: " + pedido.getId() + "\n Itens do Pedido " + pedido.getListaItemVenda()
                    + "\n Cliente:" + pedido.getCliente() + "\n Valor Total:" + pedido.getValorTotal();
        }
    }

    private void carregarPedidosRecentes() {
        listaPedidos = Controller.getInstance().retornarPedidos();
        ArrayList<GerenciadorPedidos> lista = Controller.getInstance().retornarPedidoPesquisado();
        String texto = "";

        for (GerenciadorPedidos pesq : lista) {
            Pedido pedido = pesq.getPedido();

            texto += "ID: " + pedido.getId() + "\n";

            texto += "Itens do Pedido:\n";
            for (ItemVenda item : pedido.getListaItemVenda()) {
                texto += " - " + item.getItem() + ": R$ " + item.getSubtotal() + "\n";
            }

            texto += "Cliente: " + pedido.getCliente().getNome() + "\n";

            texto += "Valor Total: R$ " + pedido.getValorTotal() + "\n\n";
        }

        tvListaPedidoRecentes.setText(texto);
    }

}