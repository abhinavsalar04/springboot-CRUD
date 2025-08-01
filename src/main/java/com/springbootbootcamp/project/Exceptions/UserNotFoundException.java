package com.springbootbootcamp.project.Exceptions;

// UserNotFoundException class extends RuntimeException instead of because for Exception we need to provide the Exception info in method signature
// Ex - public void method() throws Exception {}
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message){
        super(message);
    }
}
