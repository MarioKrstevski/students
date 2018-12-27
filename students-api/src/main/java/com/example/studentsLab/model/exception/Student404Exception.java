package com.example.studentsLab.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class Student404Exception extends Exception{
    String index;

    public Student404Exception(String index) {
        this.index = index;
    }

    @Override
    public String getMessage() {
        return String.format("Could not find student with index %s", index);
    }
}
