package com.example.apptest.repository;

import com.example.apptest.services.CourseService;
import com.example.apptest.services.TeacherService;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {

    private Retrofit retrofit;

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://professor-allocation.herokuapp.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public TeacherService getAllTeachers() {
        return retrofit.create(TeacherService.class);
    }
    public CourseService getAllCourses() {
        return retrofit.create(CourseService.class);
    }
}
