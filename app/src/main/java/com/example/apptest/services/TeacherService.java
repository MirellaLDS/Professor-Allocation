package com.example.apptest.services;

import com.example.apptest.model.Teacher;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface TeacherService {

    @GET("professor")
    Call<List<Teacher>> getAllTeachers();
}
