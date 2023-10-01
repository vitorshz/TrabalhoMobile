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
import com.example.trabalhomobile.modelos.Item;
import com.example.trabalhomobile.modelos.ItemVenda;
import com.example.trabalhomobile.modelos.Pedido;

import java.util.ArrayList;

public class GerenciadorPedidosActivity extends AppCompatActivity {
    private EditText edIdPedido;
    private Button btAddPedido;
    private TextView tvListaPedido;
    private ArrayList<Pedido> listaPedidos;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Item> listaItens;
    private ArrayList<ItemVenda> listaItenVenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerenciador_pedidos);

        edIdPedido = findViewById(R.id.edIdPedido);
        btAddPedido = findViewById(R.id.btAddPedido);
        tvListaPedido = findViewById(R.id.tvListaPedido);

        carregarClientes();
        carregarItens();
        carregarItensVenda();
        carregarPedidos();
        btAddPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pesquisarPedido();
            }
        });
    }

    private void pesquisarPedido() {
        int idPedido = Integer.parseInt(edIdPedido.getText().toString());
        if (!edIdPedido.getText().toString().isEmpty()) {
            Pedido pedidoEncontrado = buscarPedidoPorId(idPedido);

            if (pedidoEncontrado != null) {
                String texto = " ID: " + pedidoEncontrado.getId() + "\n Itens do Pedido " + pedidoEncontrado.getListaItemVenda()
                        + "\n Cliente:" + pedidoEncontrado.getCliente() + "\n Valor Total:" + pedidoEncontrado.getValorTotal();
                tvListaPedido.setText(texto);
            } else {
                Toast.makeText(this, "Pedido não encontrado", Toast.LENGTH_SHORT).show();
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
        String[] vetPedidos = new String[listaPedidos.size() + 1];
        vetPedidos[0] = "Selecione o pedido";
        for (int i = 0; i < listaPedidos.size(); i++) {
            Pedido pedido = listaPedidos.get(i);
            vetPedidos[i + 1] = " ID: " + pedido.getId() + "\n Itens do Pedido " + pedido.getListaItemVenda()
                    + "\n Cliente:" + pedido.getCliente() + "\n Valor Total:" + pedido.getValorTotal();
        }

    }

}