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

import java.io.Serializable;
import java.util.List;

class Cards implements Serializable {
    public Cards(int src, String title, CardType type) {
        this.src = src;
        this.title = title;
        this.type = type;
    }
    int src;
    String title;
    CardType type;
}

enum CardType {
    TEACHER(0), COURSE(1), K(2), A(3);

    CardType(int index) {
        this.index = index;
    }

    private int index;

    public int getIndex() {
        return index;
    }
}

public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.CardHolder> {

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
    public CardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.card_item, parent, false);
        return new CardHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardHolder holder, int position) {
        Cards item = cardList.get(position);
        holder.mProfessorName.setText(item.title);
        holder.mProfessorImage.setImageResource(item.src);
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }

    public static final String LIST_KEY = "type";
    class CardHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView mProfessorImage;
        public TextView mProfessorName;
        public CardView mComponentePai;

        public CardHolder(@NonNull View itemView) {
            super(itemView);

            mProfessorImage = itemView.findViewById(R.id.img);
            mProfessorName = itemView.findViewById(R.id.professor_name);
            mComponentePai = itemView.findViewById(R.id.card_container);

            mComponentePai.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, ListActivity.class);
//            intent.putExtra(LIST_KEY, cardList.get(getLayoutPosition()));
            intent.putExtra(ListActivity.KEY_ORIGIN, cardList.get(getLayoutPosition()));
            context.startActivity(intent);
        }
    }
}
