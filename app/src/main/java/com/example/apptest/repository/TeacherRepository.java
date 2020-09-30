package com.example.apptest.repository;

import com.example.apptest.model.Teacher;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeacherRepository {

    public void getAll(final RequestResult listner) {
        Call<List<Teacher>> call = new RetrofitConfig().getAllTeachers().getAllTeachers();

        call.enqueue(new Callback<List<Teacher>>() {
            @Override
            public void onResponse(Call<List<Teacher>> call, Response<List<Teacher>> response) {
                List<Teacher> teachers = response.body();
                listner.returnSuccess(teachers);
            }

            @Override
            public void onFailure(Call<List<Teacher>> call, Throwable t) {
                listner.returnError("Deu erro na requisição! Error message: \n" + t.getMessage());
            }
        });
    }
}
