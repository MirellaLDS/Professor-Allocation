package com.example.apptest.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.apptest.R;
import com.example.apptest.model.Course;
import com.example.apptest.repository.RequestResult;
import com.example.apptest.repository.RetrofitConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateCourseActivity extends AppCompatActivity {


    private Course curso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_course);

        curso = (Course) getIntent().getSerializableExtra(CourseAdapter.ITEM_ID_EXTRA);

        Button btEnviar = findViewById(R.id.bt_enviar);
        final EditText editText = findViewById(R.id.ed_course_name);

        editText.setText(curso.getName());

        btEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString().trim();

                if(!curso.getName().equalsIgnoreCase(text)) {

                    curso.setName(text);

                    updateCourse(curso.getId(), curso, new RequestResult() {
                        @Override
                        public <T> void returnSuccess(T requestResult) {

                        }

                        @Override
                        public void returnError(String message) {

                        }
                    });
                }
            }
        });
    }

    private void updateCourse(int id, Course course, RequestResult result) {
        Call<Course> call = new RetrofitConfig().getCourseService().updateCourse(id, course);

        call.enqueue(new Callback<Course>() {
            @Override
            public void onResponse(Call<Course> call, Response<Course> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(CreateCourseActivity.this, "Sucesso", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Course> call, Throwable t) {
                Toast.makeText(CreateCourseActivity.this, "Falha", Toast.LENGTH_LONG).show();
            }
        });
    }

}