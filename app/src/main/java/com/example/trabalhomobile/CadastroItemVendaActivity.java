package com.example.trabalhomobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trabalhomobile.modelos.Item;

public class CadastroItemVendaActivity extends AppCompatActivity {
    private EditText edCodItem;
    private EditText edDescItem;
    private EditText edValorUnitItem;
    private Button btSalvarItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_item_venda);
        setTitle("Cadastro de Item");
        edCodItem = findViewById(R.id.edCodItem);
        edDescItem = findViewById(R.id.edDescItem);
        edValorUnitItem = findViewById(R.id.edValorUnitItem);
        btSalvarItem = findViewById(R.id.btSalvarItem);

        btSalvarItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarItem();
            }
        });
    }

    private void salvarItem() {

        if (edCodItem.getText().toString().isEmpty()){
            edCodItem.setError("Informe o código do item!!");
            edCodItem.requestFocus();
            return;
        }
        int codItem = Integer.parseInt(edCodItem.getText().toString());
        if (codItem == 0){
            edCodItem.setError("Informe o código do item!!");
            edCodItem.requestFocus();
            return;
        }

        if (edDescItem.getText().toString().isEmpty()){
            edDescItem.setError("Informe a Descrição do item!!");
            edDescItem.requestFocus();
            return;
        }

        double valorUnit = Double.parseDouble(edValorUnitItem.getText().toString());
        if (valorUnit == 0){
            edCodItem.setError("Informe o Valor Unitário do item!!");
            edCodItem.requestFocus();
            return;
        }

        Item item = new Item();
        item.setCod(codItem);
        item.setDescricao(edDescItem.getText().toString());
        item.setValorUnit(valorUnit);

        Controller.getInstance().salvarItens(item);
        Toast.makeText(this, "Item cadastrado com Sucesso!", Toast.LENGTH_LONG).show();
        this.finish();


    }
}