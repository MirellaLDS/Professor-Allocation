package com.example.apptest.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;

import com.example.apptest.R;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        List<Cards> cardList = Arrays.asList(
                new Cards(R.drawable.ic_education, "Professores", CardType.TEACHER),
                new Cards(R.drawable.ic_learning, "Cursos", CardType.COURSE),
                new Cards(R.drawable.ic_department, "Departamento", CardType.TEACHER),
                new Cards(R.drawable.ic_allocation, "Alocação", CardType.TEACHER));

        RecyclerView recyclerView = findViewById(R.id.recycle);
        //TODO: Passar lista de professores
        recyclerView.setAdapter(new CardsAdapter(this, cardList));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }


}