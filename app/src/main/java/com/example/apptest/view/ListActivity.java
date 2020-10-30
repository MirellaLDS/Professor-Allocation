package com.example.apptest.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.apptest.R;

public class ListActivity extends AppCompatActivity {

    public final static String KEY_ORIGIN = "origin";
    private Cards originView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        setupToolbar();

        originView = (Cards) getIntent().getSerializableExtra(KEY_ORIGIN);
        if (originView != null) {
            int typeView = originView.type.getIndex();

            if (CardType.COURSE.getIndex() == typeView) {
                ListCoursesFragment listCoursesFragment = new ListCoursesFragment();
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_lists, listCoursesFragment).commit();
            } else {
                ListTeachersFragment listTeachersFragment = new ListTeachersFragment();
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_lists, listTeachersFragment).commit();
            }
        }
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_left_arrow);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                // User chose the "Settings" item, show the app settings UI...
                Toast.makeText(this, "Create", Toast.LENGTH_LONG).show();
                return true;

            case R.id.action_delete:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                Toast.makeText(this, "Delete", Toast.LENGTH_LONG).show();
                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                finish();
                return super.onOptionsItemSelected(item);

        }
    }

}