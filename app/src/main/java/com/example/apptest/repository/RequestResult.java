package com.example.apptest.repository;

public interface RequestResult {
    <T> void returnSuccess(T requestResult);
    void returnError(String message);
}
