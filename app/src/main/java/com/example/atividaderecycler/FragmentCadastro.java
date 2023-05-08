package com.example.atividaderecycler;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentCadastro#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentCadastro extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    EditText nome, tipo, preco;
    Button btnCadastro;
    ArrayList<Produto> listaProdutos = new ArrayList<>();

    public FragmentCadastro() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentCadastro.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentCadastro newInstance(String param1, String param2) {
        FragmentCadastro fragment = new FragmentCadastro();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cadastro, container, false);
        // Inflate the layout for this fragment
        FragmentLista.listaProdutos = listaProdutos;
        nome = v.findViewById(R.id.txtNome);
        tipo = v.findViewById(R.id.txtTipo);
        preco = v.findViewById(R.id.numPreco);
        btnCadastro = v.findViewById(R.id.btnCadastro);
        btnCadastro.setOnClickListener(click -> {cadastro();});
        return v;
    }

    public void cadastro(){
        try {
            String name = nome.getText().toString();
            String type = tipo.getText().toString();
            float price = Float.parseFloat(preco.getText().toString());
            Produto p = new Produto(name, type, price);
            listaProdutos.add(p);
            FragmentLista.listaProdutos = listaProdutos;
        }catch (Exception e){
            Toast.makeText(getContext(), "Insira um valor válido", Toast.LENGTH_SHORT).show();}
    }
}