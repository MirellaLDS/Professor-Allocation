package com.example.apptest.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.apptest.R;
import com.example.apptest.model.Course;
import com.example.apptest.repository.CourseRepository;
import com.example.apptest.repository.RequestResult;
import com.example.apptest.repository.RetrofitConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateCourseActivity extends AppCompatActivity {

    private Course curso;
    private Button btEnviar;
    private CourseRepository courseRepository = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_course);

        courseRepository = new CourseRepository();
        curso = (Course) getIntent().getSerializableExtra(CourseAdapter.ITEM_ID_EXTRA);

        btEnviar = findViewById(R.id.bt_enviar);
        Button btApagar = findViewById(R.id.bt_apagar);
        final EditText editText = findViewById(R.id.ed_course_name);

        if (curso != null) {
            editText.setText(curso.getName());
            btApagar.setVisibility(View.VISIBLE);
            btApagar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    deleteCourse();
                }
            });
        }
        btEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEditView(editText);
            }
        });
    }

    private void deleteCourse() {
        courseRepository.apagarCurso(curso.getId(), new RequestResult() {
            @Override
            public <T> void returnSuccess(T requestResult) {
                Toast.makeText(CreateCourseActivity.this, "Item deletado com sucesso!", Toast.LENGTH_LONG).show();
                finish();
            }

            @Override
            public void returnError(String message) {
                Toast.makeText(CreateCourseActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void openEditView(final EditText editText) {

        String text = editText.getText().toString().trim();

        if (curso == null) {
            curso = new Course(0, text);
            courseRepository.createCourse(curso, new RequestResult() {
                @Override
                public <T> void returnSuccess(T requestResult) {
                    Toast.makeText(CreateCourseActivity.this, "Sucesso", Toast.LENGTH_LONG).show();
                    finish();
                }

                @Override
                public void returnError(String message) {
                    Toast.makeText(CreateCourseActivity.this, message, Toast.LENGTH_LONG).show();
                }
            });
        } else {
            curso.setName(text);
            updateCourse(curso.getId(), curso, new RequestResult() {
                @Override
                public <T> void returnSuccess(T requestResult) {
                    Toast.makeText(CreateCourseActivity.this, "Sucesso", Toast.LENGTH_LONG).show();
                    finish();
                }

                @Override
                public void returnError(String message) {
                    Toast.makeText(CreateCourseActivity.this, message, Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    private void updateCourse(int id, Course course, final RequestResult result) {
        Call<Course> call = new RetrofitConfig().getCourseService().updateCourse(id, course);

        call.enqueue(new Callback<Course>() {
            @Override
            public void onResponse(Call<Course> call, Response<Course> response) {
                if (response.isSuccessful()) {
                    result.returnSuccess(response.body());
                } else {
                    result.returnError("Erro ao tentar salvar");
                }
            }

            @Override
            public void onFailure(Call<Course> call, Throwable t) {
                result.returnError("Erro ao tentar acessar o servidor");
            }
        });
    }

}