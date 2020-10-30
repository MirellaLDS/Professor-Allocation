package com.example.apptest.repository;

import com.example.apptest.model.Course;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CourseRepository {
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
