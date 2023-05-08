package com.example.atividaderecycler;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentLista#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentLista extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    RecyclerView recycler;
    static ArrayList<Produto> listaProdutos;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentLista() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentLista.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentLista newInstance(String param1, String param2) {
        FragmentLista fragment = new FragmentLista();
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
        View v = inflater.inflate(R.layout.fragment_lista, container, false);
        recycler = v.findViewById(R.id.rv);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        Adaptador adaptador = new Adaptador(getContext(), listaProdutos, new Adaptador.OnItemClickListerner() {
            @Override
            public void onItemClick(Produto p) {
                Toast.makeText(getContext(), p.getNome(), Toast.LENGTH_SHORT).show();
            }});
        recycler.setAdapter(adaptador);
        adaptador.notifyDataSetChanged();
        return v;
    }
}