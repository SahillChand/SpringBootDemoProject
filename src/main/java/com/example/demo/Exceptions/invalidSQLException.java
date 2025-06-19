package com.example.demo.Exceptions;

public class invalidSQLException extends RuntimeException{

    public invalidSQLException(String message) {
        super(message);
    }

}
