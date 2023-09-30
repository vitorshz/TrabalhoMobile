package com.example.trabalhomobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trabalhomobile.modelos.Cliente;
import com.example.trabalhomobile.modelos.Item;

import java.util.ArrayList;
import java.util.List;

public class CadastroPedidoActivity extends AppCompatActivity {
    private Spinner spItens;
    private TextView tvListaItens;
    private Button btAddItens;
    private AutoCompleteTextView actvCliente;
    private Button btAddCliente;
    private TextView tvValorTotalPedido;
    private RadioGroup rgPagamento;
    private RadioButton rbPgVista;
    private RadioButton rbPgPrazo;
    private Spinner spParcelas;
    private Button btConcluirPedido;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Item> listaItens;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pedido);

        spItens = findViewById(R.id.spItens);
        tvListaItens = findViewById(R.id.tvListaItens);
        btAddItens = findViewById(R.id.btAddItens);
        actvCliente = findViewById(R.id.actvCliente);
        btAddCliente = findViewById(R.id.btAddCliente);
        tvValorTotalPedido = findViewById(R.id.tvValorTotalPedido);
        rgPagamento = findViewById(R.id.rgPagamento);
        rbPgVista = findViewById(R.id.rbPgVista);
        rbPgPrazo = findViewById(R.id.rbPgPrazo);
        spParcelas = findViewById(R.id.spParcelas);
        btConcluirPedido = findViewById(R.id.btConcluirPedido);

        carregarClientes();
        carregarItens();
        calcularTotalPedido();


    }
    private void carregarClientes(){
        listaClientes = Controller.getInstance().retornarClientes();
        String[]vetCliente = new String[listaClientes.size()];
        for (int i = 0; i < listaClientes.size(); i++) {
            Cliente cliente = listaClientes.get(i);
            vetCliente[i] = cliente.getNome();
        }
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_dropdown_item_1line, vetCliente);

        actvCliente.setAdapter(adapter);
    }
    private void carregarItens(){
        listaItens = Controller.getInstance().retornarItem();
        String[]vetItens = new String[listaItens.size() + 1];
        vetItens[0] = "Selecione o professor";
        for (int i = 0; i < listaItens.size(); i++) {
            Item item = listaItens.get(i);
            vetItens[i+1] = item.getDescricao()+" R$ "+item.getValorUnit();
        }
        ArrayAdapter adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_dropdown_item_1line,
                vetItens);

        spItens.setAdapter(adapter);

    }
    private void calcularParcelas(double valorTotal, int numeroParcelas) {
        List<String> parcelas = new ArrayList<>();

        if (numeroParcelas > 0) {
            double valorParcela = valorTotal / numeroParcelas;

            for (int i = 1; i <= numeroParcelas; i++) {
                parcelas.add(i + "x R$ " + String.format("%.2f", valorParcela));
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(
                    this,
                    android.R.layout.simple_dropdown_item_1line,
                    parcelas
            );

            spItens.setAdapter(adapter);
        }
    }


    private double calcularTotalPedido() {
        double total = 0.0;

        for (Item item : listaItens) {
            total += item.getValorUnit();
        }

        // Verifica o tipo de pagamento selecionado (à vista ou a prazo) e aplica desconto ou acréscimo.
        if (rbPgVista.isChecked()) {
            total *= 0.95; // Aplicar desconto de 5% para pagamento à vista.
        } else {
            total *= 1.05; // Aplicar acréscimo de 5% para pagamento a prazo.
            calcularParcelas(total,12);
        }

        // Atualize a exibição do total do pedido, se desejar.
        tvValorTotalPedido.setText(String.format("Total do Pedido: R$ %.2f", total));

        return total;
    }

}