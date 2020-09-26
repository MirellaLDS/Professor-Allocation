package com.example.apptest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycle);
        //TODO: Passar lista de professores
        recyclerView.setAdapter(new CardsAdapter(this, new LinkedList()));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }
}