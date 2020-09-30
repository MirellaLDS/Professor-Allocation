package com.example.apptest.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apptest.R;

import java.util.ArrayList;
import java.util.List;

class Cards {
    public Cards(int src, String title) {
        this.src = src;
        this.title = title;
    }
    int src;
    String title;
}

public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.ReceitaHolder> {

    private Context context;
    private List<Cards> cardList;
    private final LayoutInflater mInflater;

    public CardsAdapter(Context context, List<Cards> cardList) {
        this.context = context;
        this.cardList = cardList;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ReceitaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.card_item, parent, false);
        return new ReceitaHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ReceitaHolder holder, int position) {
        Cards item = cardList.get(position);
        holder.mProfessorName.setText(item.title);
        holder.mProfessorImage.setImageResource(item.src);
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }

    public static final String DETALHES_KEY = "Receita";
    class ReceitaHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView mProfessorImage;
        public TextView mProfessorName;
        public CardView mComponentePai;

        public ReceitaHolder(@NonNull View itemView) {
            super(itemView);

            mProfessorImage = itemView.findViewById(R.id.img);
            mProfessorName = itemView.findViewById(R.id.professor_name);
            mComponentePai = itemView.findViewById(R.id.card_container);

            mComponentePai.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, ListActivity.class);
            intent.putExtra(DETALHES_KEY, new ArrayList<>());
            context.startActivity(intent);
        }
    }
}
