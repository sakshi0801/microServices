/**
 * This class is a custom defined exception class
 */

package com.stackroute.userservice.exception;

public class UserAlreadyExistException extends  Exception {
    private String message;

    public UserAlreadyExistException() {
    }
    public UserAlreadyExistException(String message)
    {
        super(message);
        this.message=message;
    }
}
