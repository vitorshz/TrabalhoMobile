package com.example.trabalhomobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trabalhomobile.modelos.Cliente;
import com.example.trabalhomobile.modelos.GerarId;
import com.example.trabalhomobile.modelos.GerenciadorPedidos;
import com.example.trabalhomobile.modelos.Item;
import com.example.trabalhomobile.modelos.ItemVenda;
import com.example.trabalhomobile.modelos.Parcela;
import com.example.trabalhomobile.modelos.Pedido;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CadastroPedidoActivity extends AppCompatActivity {
    private Spinner spItens;
    private TextView tvListaItens;
    private ImageButton btAddItens;
    private AutoCompleteTextView actvCliente;
    private TextView tvNomeCliente;
    private ImageButton btAddCliente;
    private TextView tvValorTotalPedido;
    private RadioGroup rgPagamento;
    private RadioButton rbPgVista;
    private RadioButton rbPgPrazo;
    private Spinner spParcelas;
    private Button btConcluirPedido;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Item> listaItens;
    private ArrayList<ItemVenda> listaItenVenda;
    private int posicaoSelecionada = 0;
    private int posCliente = 0;
    private Cliente clienteSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pedido);
        setTitle("Cadastro de Pedido");

        spItens = findViewById(R.id.spItens);
        tvListaItens = findViewById(R.id.tvListaItens);
        actvCliente = findViewById(R.id.actvCliente);
        btAddCliente = findViewById(R.id.btAddCliente);
        tvValorTotalPedido = findViewById(R.id.tvValorTotalPedido);
        rgPagamento = findViewById(R.id.rgPagamento);
        rbPgVista = findViewById(R.id.rbPgVista);
        rbPgPrazo = findViewById(R.id.rbPgPrazo);
        spParcelas = findViewById(R.id.spParcelas);
        btConcluirPedido = findViewById(R.id.btConcluirPedido);
        tvNomeCliente = findViewById(R.id.tvNomeCliente);
        btAddItens = findViewById(R.id.btAddItens);


        carregarClientes();
        carregarItens();
        carregarItensVenda();

        btAddItens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adicionarItemAoPedido();
            }
        });

        spItens.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int posicao, long l) {
                if (posicao > 0) {
                    posicaoSelecionada = posicao;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        actvCliente.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int posicao, long l) {
                if (posicao > 0) {
                    posCliente = posicao;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btAddCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adicionarCliente();
            }
        });

        rgPagamento.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (rbPgVista.isChecked()) {
                    calcularTotalPedido();
                } else if (rbPgPrazo.isChecked()) {
                    spParcelas.setVisibility(View.VISIBLE);
                    calcularParcelas();
                    calcularTotalPedido();

                }
            }
        });
        btConcluirPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarPedido();
            }
        });


    }

    private void adicionarCliente() {
        clienteSelecionado = listaClientes.get(posCliente);
        String texto = "Nome: " + clienteSelecionado.getNome() + "\n"
                + "CPF: " + clienteSelecionado.getCpf() + "\n"
                + "-----------------------------------------\n";
        tvNomeCliente.setText(texto);
        Controller.getInstance().salvarCliente(clienteSelecionado);

    }

    private void adicionarItemAoPedido() {
        Item item = listaItens.get(posicaoSelecionada - 1);
        ItemVenda itemVenda = new ItemVenda();
        itemVenda.setSubtotal(item.getValorUnit());
        itemVenda.setQuantidade(1);
        itemVenda.setItem(item);

        Controller.getInstance().salvarItensVenda(itemVenda);
        atualizarExibicaoItensVenda();
    }

    private void atualizarExibicaoItensVenda() {
        ArrayList<ItemVenda> lista = Controller.getInstance().retornarItensVenda();
        String texto = "";
        for (ItemVenda ItVd : lista) {
            Item exItem = ItVd.getItem();
            texto += "\n" + "Item: " + exItem.getDescricao() + "\n" + "R$: "
                    + ItVd.getSubtotal() + "\n---------------------------------------------\n";
        }
        tvListaItens.setText(texto);
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
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, vetCliente);
        actvCliente.setAdapter(adapter);
    }

    private void carregarItens() {
        listaItens = Controller.getInstance().retornarItem();
        String[] vetItens = new String[listaItens.size() + 1];
        vetItens[0] = "Selecione o Item";
        for (int i = 0; i < listaItens.size(); i++) {
            Item item = listaItens.get(i);
            vetItens[i + 1] = item.getDescricao() + " R$ " + item.getValorUnit();
        }
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, vetItens);

        spItens.setAdapter(adapter);

    }

    private void calcularParcelas() {
        // Configurar um ArrayAdapter para o Spinner de Parcelas (1 a 12)
        List<Parcela> opcoesParcelas = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            double valorTotal = calcularTotalPedido();
            double valorParcela = valorTotal / i;
            Parcela parcela = new Parcela(i, valorParcela);
            opcoesParcelas.add(parcela);
        }

        ArrayAdapter<Parcela> adapterParcelas = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opcoesParcelas);
        adapterParcelas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spParcelas.setAdapter(adapterParcelas);
    }


    private double calcularTotalPedido() {
        double total = 0.0;

        for (ItemVenda item : listaItenVenda) {
            total += item.getSubtotal();
        }

        if (rbPgVista.isChecked()) {
            total *= 0.95; // Aplicar desconto de 5% para pagamento à vista.
        } else {
            total *= 1.05; // Aplicar acréscimo de 5% para pagamento a prazo.
        }
        tvValorTotalPedido.setText(String.format("R$ %.2f", total));

        return total;
    }

    private void salvarPedido() {
        try {
            GerarId gerar = new GerarId();
            int idgerado = gerar.gerarProximoId();

            double valorTotal = calcularTotalPedido();

            if (clienteSelecionado == null) {
                Toast.makeText(this, "Selecione um cliente.", Toast.LENGTH_SHORT).show();
                return; // Sai do método se o cliente não estiver selecionado.
            }

            // Verificar se há itens no pedido.
            if (listaItenVenda.isEmpty()) {
                Toast.makeText(this, "Adicione pelo menos um item ao pedido.", Toast.LENGTH_SHORT).show();
                return; // Sai do método se não houver itens no pedido.
            }

            Pedido pedido = new Pedido();
            pedido.setId(idgerado);
            pedido.setCliente(clienteSelecionado);
            pedido.setListaItemVenda(listaItenVenda);
            pedido.setValorTotal(valorTotal);

            Controller.getInstance().salvarPedidos(pedido);

            Toast.makeText(CadastroPedidoActivity.this, "Pedido salvo com sucesso!! ID: "
                    +pedido.getId(), Toast.LENGTH_LONG).show();
            this.finish();

        } catch (Exception e) {

            e.printStackTrace();
            Toast.makeText(this, "Erro ao salvar o pedido.", Toast.LENGTH_SHORT).show();

        }
    }


}