package com.marcosoft.usdobjectmodellab.exception;

public class UsdCrNotFoundException extends Exception{

    public UsdCrNotFoundException(String message){
        super(message);
    }
    public UsdCrNotFoundException(String message, Throwable cause){
        super(message,cause);
    }
}
