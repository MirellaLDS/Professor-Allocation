package com.example.apptest.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.apptest.R;
import com.example.apptest.model.Teacher;
import com.example.apptest.repository.RequestResult;
import com.example.apptest.repository.TeacherRepository;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    TeacherRepository teacherRepository = null;
    ListAdapter listAdapter;
    List<Teacher> teachers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        teacherRepository = new TeacherRepository();

        RecyclerView recyclerView = findViewById(R.id.list_recycler);
        listAdapter = new ListAdapter(ListActivity.this, teachers);

        recyclerView.setAdapter(listAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getAll();
    }

    private void getAll() {
        teacherRepository.getAll(new RequestResult() {
            @Override
            public <T> void returnSuccess(T requestResult) {
                teachers = (List<Teacher>) requestResult;
                listAdapter.setList(teachers);
                listAdapter.notifyDataSetChanged();
            }

            @Override
            public void returnError(String message) {
                Toast.makeText(ListActivity.this, message, Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}