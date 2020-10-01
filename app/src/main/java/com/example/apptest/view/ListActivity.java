package com.example.apptest.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
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

        setupToolbar();

        RecyclerView recyclerView = findViewById(R.id.list_recycler);
        listAdapter = new ListAdapter(ListActivity.this, teachers);

        recyclerView.setAdapter(listAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getAll();
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_left_arrow);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void getAll() {
        final LoaddingDialog dialog = new LoaddingDialog(this);
        dialog.startDialog();
        teacherRepository.getAll(new RequestResult() {
            @Override
            public <T> void returnSuccess(T requestResult) {
                teachers = (List<Teacher>) requestResult;
                listAdapter.setList(teachers);
                listAdapter.notifyDataSetChanged();
                dialog.dismissDialog();
            }

            @Override
            public void returnError(String message) {
                dialog.dismissDialog();
                Toast.makeText(ListActivity.this, message, Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}