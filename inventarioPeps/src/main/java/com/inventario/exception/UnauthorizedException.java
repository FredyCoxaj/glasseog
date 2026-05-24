package com.inventario.exception;

public class UnauthorizedException extends RuntimeException {
    
    private String errorCode;
    
    // Constructores
    public UnauthorizedException(String message) {
        super(message);
    }
    
    public UnauthorizedException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    
    public UnauthorizedException(String message, Throwable cause) {
        super(message, cause);
    }
    
    // Getters y Setters
    public String getErrorCode() {
        return errorCode;
    }
    
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}