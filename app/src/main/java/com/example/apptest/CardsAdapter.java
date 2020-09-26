package com.example.apptest;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.LinkedList;

public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.ReceitaHolder> {

    private Context context;
    private LinkedList<String> listaDeReceitas;

    private final LayoutInflater mInflater;

    public CardsAdapter(Context context, LinkedList listaDeReceitas) {
        this.context = context;
        this.listaDeReceitas = listaDeReceitas;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ReceitaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = mInflater.inflate(R.layout.card_iten, parent, false);

        return new ReceitaHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ReceitaHolder holder, int position) {

//        Receitas receita = listaDeReceitas.get(position);
//
//        String titulo = receita.getName();
//        String mensagem = receita.getDescription();
//
//        holder.mTitulo.setText(titulo);
//        holder.mProfessorName.setText(mensagem);
    }

    @Override
    public int getItemCount() {
        return listaDeReceitas.size();
    }

    public static final String DETALHES_KEY = "Receita";
    class ReceitaHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView mProfessorImage;
        public TextView mProfessorName;
        public ConstraintLayout mComponentePai;

        public ReceitaHolder(@NonNull View itemView) {
            super(itemView);

            mProfessorName = itemView.findViewById(R.id.professor_name);
            mComponentePai = itemView.findViewById(R.id.card_container);

            mComponentePai.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, DetailsActivity.class);
            intent.putExtra(DETALHES_KEY, new ArrayList<>());
            context.startActivity(intent);
        }
    }
}
