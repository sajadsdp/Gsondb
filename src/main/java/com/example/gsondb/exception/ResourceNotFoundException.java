package com.example.gsondb.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String massage){
        super(massage);
    }
}
