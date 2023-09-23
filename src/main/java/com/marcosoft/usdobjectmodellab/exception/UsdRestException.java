package com.marcosoft.usdobjectmodellab.exception;

public class UsdRestException extends Exception{
    public UsdRestException(String message){
        super(message);
    }
    public UsdRestException(String message, Throwable cause){
        super(message,cause);
    }
}
