package com.example.apptest.repository;

import com.example.apptest.model.Course;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CourseRepository {

    public void createCourse(Course course, final RequestResult result) {
        Call<Course> call = new RetrofitConfig().getCourseService().createCourse(course);

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

    public void apagarCurso(int id, final RequestResult result) {
        Call<Course> call = new RetrofitConfig().getCourseService().deleteCoutse(id);
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

    public void getAll(final RequestResult listner) {
        Call<List<Course>> call = new RetrofitConfig().getCourseService().getAllCourses();

        call.enqueue(new Callback<List<Course>>() {
            @Override
            public void onResponse(Call<List<Course>> call, Response<List<Course>> response) {
                List<Course> course = response.body();
                listner.returnSuccess(course);
            }

            @Override
            public void onFailure(Call<List<Course>> call, Throwable t) {
                listner.returnError("Deu erro na requisição! Error message: \n" + t.getMessage());
            }
        });
    }
}
