package com.springbootbootcamp.project.Exceptions;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ErrorResponse {
    // All data members which need to show in response must be public
    public String message; // to show error message to user
    public int status;
    HttpStatus completeStatus; // just for internal user so does not public
    public String error; // for debugging purpose
    public LocalDateTime timestamp;

    public ErrorResponse(String message, HttpStatus status, String error){
        this.message = message;
        this.status = status.value();
        this.completeStatus = status;
        this.error = error;
        this.timestamp = LocalDateTime.now();
    }
}
