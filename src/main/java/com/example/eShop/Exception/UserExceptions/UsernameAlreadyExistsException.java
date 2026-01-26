package com.example.eShop.Exception.UserExceptions;

public class UsernameAlreadyExistsException  extends RuntimeException{
    public UsernameAlreadyExistsException(String message){
        super(message);
    }   
}
