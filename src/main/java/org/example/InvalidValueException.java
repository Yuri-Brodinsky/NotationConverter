package org.example;

public class InvalidValueException extends RuntimeException{
    public InvalidValueException(String message){
        super(message);
    }
}