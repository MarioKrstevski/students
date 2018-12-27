package com.example.studentsLab.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)

public class StudyProgramExistsException extends Exception {
    String name;

    @Override
    public String getMessage() {
        return "The study program already exists";
    }
}
