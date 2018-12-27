package com.example.studentsLab.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IndexFormatException extends Exception {
    String index;

    public IndexFormatException(String index) {
        this.index = index;
    }

    @Override
    public String getMessage() {
        return String.format("The index %s has to be a 6-digit number", index);
    }
}
