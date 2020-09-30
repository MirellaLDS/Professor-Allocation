package com.example.apptest.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import com.example.apptest.R;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Cards> cardList = Arrays.asList(
                new Cards(R.drawable.ic_education, "Professores"),
                new Cards(R.drawable.ic_learning, "Cursos"),
                new Cards(R.drawable.ic_department, "Departamento"),
                new Cards(R.drawable.ic_allocation, "Alocação"));

        RecyclerView recyclerView = findViewById(R.id.recycle);
        //TODO: Passar lista de professores
        recyclerView.setAdapter(new CardsAdapter(this, cardList));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }
}