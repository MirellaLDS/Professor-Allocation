package com.example.apptest.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;

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
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}