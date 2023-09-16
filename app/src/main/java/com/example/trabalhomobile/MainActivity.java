package com.example.trabalhomobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btCadastroCliente;
    private Button btCadastroItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCadastroCliente = findViewById(R.id.btCadastroCliente);
        btCadastroItem = findViewById(R.id.btCadastroItem);
        btCadastroCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirActivity(CadastroClienteActivity.class);
            }
        });

        btCadastroItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirActivity(CadastroItemVendaActivity.class);
            }
        });
    }
    private void abrirActivity(Class<?> activity){
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }
}