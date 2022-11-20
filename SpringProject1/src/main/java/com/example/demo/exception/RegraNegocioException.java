package com.example.demo.exception;

//primeira exception personalizada que eu criei
public class RegraNegocioException extends RuntimeException{

    public RegraNegocioException(String message) {
        super(message);
    }
}
