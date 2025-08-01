package com.springbootbootcamp.project.Configurations;

import com.springbootbootcamp.project.Exceptions.BookNotFoundException;
import com.springbootbootcamp.project.Exceptions.ErrorResponse;
import com.springbootbootcamp.project.Exceptions.StoryNotFoundException;
import com.springbootbootcamp.project.Exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> userNotFoundException(UserNotFoundException exception){
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.getReasonPhrase());
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ErrorResponse> bookNotFoundException(BookNotFoundException exception){
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.getReasonPhrase());
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StoryNotFoundException.class)
    public ResponseEntity<ErrorResponse> storyNotFoundException(StoryNotFoundException exception){
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.getReasonPhrase());
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> genericExceptionHandler(Exception exception){
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(), HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.getReasonPhrase());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
