package com.example.apptest.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apptest.R;
import com.example.apptest.model.Course;
import com.example.apptest.model.Teacher;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ListHolder> {
    private Context context;
    private List<Course> lista;
    private final LayoutInflater mInflater;

    public final static String ITEM_ID_EXTRA = "CursoID";

    public CourseAdapter(Context context, List<Course> lista) {
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
        Course course = lista.get(position);
        holder.mUserName.setText(course.getName());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public void setList(List<Course> course) {
        lista = course;
    }

    public class ListHolder extends RecyclerView.ViewHolder {
        public TextView mUserName;
        private ConstraintLayout parentLayout;

        public ListHolder(@NonNull View itemView) {
            super(itemView);
            mUserName = itemView.findViewById(R.id.teacher_name);
            parentLayout = itemView.findViewById(R.id.parent_container);

            parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, CreateCourseActivity.class);
                    Course course =  lista.get(getAdapterPosition());
//            intent.putExtra(ITEM_ID_EXTRA, course);
                    intent.putExtra(ITEM_ID_EXTRA, course);
                    context.startActivity(intent);
                }
            });
        }
    }
}
