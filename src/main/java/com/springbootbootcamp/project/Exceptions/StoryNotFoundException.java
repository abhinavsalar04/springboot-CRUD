package com.springbootbootcamp.project.Exceptions;

public class StoryNotFoundException extends RuntimeException{
    public StoryNotFoundException(String message){
        super(message);
    }
}
