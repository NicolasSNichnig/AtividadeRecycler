package com.example.atividaderecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class lista extends AppCompatActivity {
    RecyclerView recycler;
    static ArrayList<Produto> listaProdutos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        getSupportActionBar().hide();
        recycler = findViewById(R.id.rv);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        Adaptador adaptador = new Adaptador(this, listaProdutos, new Adaptador.OnItemClickListerner() {
            @Override
            public void onItemClick(Produto p) {
                Toast.makeText(lista.this, p.getNome(), Toast.LENGTH_SHORT).show();
            }});
        recycler.setAdapter(adaptador);
        adaptador.notifyDataSetChanged();

    }

    /*public void cadastroInicial(){

        Produto p1 = new Produto("arroz", "Alimento", (float)9.99);
        Produto p2 = new Produto("macarrão", "Alimento", (float)20.00);
        Produto p3 = new Produto("Salgadinho", "Snack", (float)10.69);
        Produto p4 = new Produto("Refri", "Bebida", (float)100.00);
        Produto p5 = new Produto("Nutella", "Alimento", (float)100000000000.00);
        listaProdutos.add(p1);
        listaProdutos.add(p2);
        listaProdutos.add(p3);
        listaProdutos.add(p4);
        listaProdutos.add(p5);
    } */
}