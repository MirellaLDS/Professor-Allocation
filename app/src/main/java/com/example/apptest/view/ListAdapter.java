package com.example.apptest.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apptest.R;
import com.example.apptest.model.Teacher;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListHolder> {
    private Context context;
    private List<Teacher> lista;
    private final LayoutInflater mInflater;

    public ListAdapter(Context context, List<Teacher> lista) {
        this.context = context;
        this.lista = lista;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.list_item, parent, false);
        return new ListHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListHolder holder, int position) {
        Teacher teacher = lista.get(position);
        holder.mUserName.setText(teacher.getName());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public void setList(List<Teacher> teachers) {
        lista = teachers;
    }

    public class ListHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView mUserName;

        public ListHolder(@NonNull View itemView) {
            super(itemView);
            mUserName = itemView.findViewById(R.id.teacher_name);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
