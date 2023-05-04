package com.example.atividaderecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText nome, tipo, preco;
    ArrayList<Produto> listaProdutos = lista.listaProdutos;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        nome = findViewById(R.id.txtNome);
        tipo = findViewById(R.id.txtTipo);
        preco = findViewById(R.id.numPreco);
    }

    public void cadastro(View v){
        try {
            String name = nome.getText().toString();
            String type = tipo.getText().toString();
            float price = Float.parseFloat(preco.getText().toString());
            Produto p = new Produto(name, type, price);
            listaProdutos.add(p);
        }catch (Exception e){Toast.makeText(this, "Insira um valor válido", Toast.LENGTH_SHORT).show();}
    }

    public void telaLista(View v){
        Intent i = new Intent(this, lista.class);
        startActivity(i);
    }
}