package com.example.studentsLab.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class Parameter404Exception extends Exception {
    String parameterName;

    public Parameter404Exception(String parameterName) {

        this.parameterName = parameterName;
    }

    @Override
    public String getMessage() {
        return String.format("%s parameter not specified", parameterName);
    }
}
