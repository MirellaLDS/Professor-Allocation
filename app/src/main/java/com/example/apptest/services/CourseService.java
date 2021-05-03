package com.example.apptest.services;

import com.example.apptest.model.Course;

import java.util.Currency;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CourseService {
    @GET("course")
    Call<List<Course>> getAllCourses();

    @PUT("course/{id}")
    Call<Course> updateCourse(@Path("id") int idCurso, @Body Course course);

    @POST("course")
    Call<Course> createCourse(@Body Course course);
}
