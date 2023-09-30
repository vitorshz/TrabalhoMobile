package com.example.trabalhomobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trabalhomobile.modelos.Cliente;

public class CadastroClienteActivity extends AppCompatActivity {
    private EditText edNomeCliente;
    private EditText edCpfCliente;
    private Button btSalvarCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cliente);
        setTitle("Cadastro do Cliente");

        edNomeCliente= findViewById(R.id.edNomeCliente);
        edCpfCliente= findViewById(R.id.edCpfCliente);
        btSalvarCliente = findViewById(R.id.btSalvarCliente);

        btSalvarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarCliente();
            }
        });
    }

    private void salvarCliente() {
        if(edNomeCliente.getText().toString().isEmpty()){
            edNomeCliente.setError("Informe o nome do cliente!");
            edNomeCliente.requestFocus();
            return;
        }
        if (edCpfCliente.getText().toString().isEmpty()){
            edCpfCliente.setError("Informe o CPF do cliente!");
            edCpfCliente.requestFocus();
            return;
        }
        Cliente cliente = new Cliente();
        cliente.setNome(edNomeCliente.getText().toString());
        cliente.setCpf(edCpfCliente.getText().toString());

        Controller.getInstance().salvarCliente(cliente);

        Toast.makeText(this, "Cliente cadastrado com Sucesso!", Toast.LENGTH_LONG).show();
        this.finish();

        //cliente de exemplo
        Cliente cliente1 = new Cliente("vito","12830912367");
    }

}