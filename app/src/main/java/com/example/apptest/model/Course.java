package com.example.apptest.model;

import java.io.Serializable;

public class Course implements Serializable {
    public Course() {
    }

    public Course(int id, String name) {
        this.id = id;
        this.name = name;
    }


    public int id;
    public String name;


//    @JsonProperty("id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
