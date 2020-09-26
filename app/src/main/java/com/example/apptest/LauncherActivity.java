package com.example.apptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.android.material.internal.ViewOverlayImpl;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                createIntent();
            }
        }, 2000);
    }

    private void createIntent(){
        Intent intent = new Intent(LauncherActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}