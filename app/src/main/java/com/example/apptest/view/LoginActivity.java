package com.example.apptest.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.apptest.R;
import com.example.apptest.utils.InternetUtils;
import com.example.apptest.utils.NotificationUtils;

public class LoginActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        InternetUtils.hasInternetConnection(this);

//        NotificationUtils notificationUtils = new NotificationUtils(this);
//        notificationUtils.startNotification();

        Button btn = findViewById(R.id.bt_log_in);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createIntent();
            }
        });
    }

    private void createIntent(){
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }


}