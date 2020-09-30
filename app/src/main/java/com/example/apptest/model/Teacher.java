package com.example.apptest.model;

public class Teacher {
    private int id;
    private String name;
    private String cpf;
    Departament departament;

    public Teacher() {
    }

    public Teacher(int id, String name, String cpf, Departament departament) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.departament = departament;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Departament getDepartament() {
        return departament;
    }

    // Setter Methods

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDepartament(Departament DepartamentObject) {
        this.departament = DepartamentObject;
    }
}
