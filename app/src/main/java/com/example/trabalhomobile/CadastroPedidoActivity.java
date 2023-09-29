package com.example.trabalhomobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CadastroPedidoActivity extends AppCompatActivity {
    private Spinner spItem;
    private TextView tvlistaItens;
    private TextView tvValorTotal;
    private RadioGroup rgFormaPagamento;
    private RadioButton rbAvista;
    private RadioButton rbPrazo;
    private Spinner spQtdParcelas;
    private Button btAddCliente;
    private Button btAddItem;
    private Button btPagar;
    private int posicaoSelecionada = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pedido);

        tvlistaItens = findViewById(R.id.tvlistaItens);
        tvValorTotal = findViewById(R.id.tvValorTotal);
        rgFormaPagamento = findViewById(R.id.rgFormaPagamento);
        rbAvista = findViewById(R.id.rbAvista);
        rbPrazo = findViewById(R.id.rbPrazo);
        spQtdParcelas = findViewById(R.id.spQtdParcelas);
        spItem = findViewById(R.id.spItem);
        btAddItem = findViewById(R.id.btAddItem);
        btAddCliente = findViewById(R.id.btAddCliente);
        btPagar = findViewById(R.id.btPagar);



    }


}