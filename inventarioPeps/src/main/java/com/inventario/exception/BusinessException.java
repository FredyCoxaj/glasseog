package com.inventario.exception;

public class BusinessException extends RuntimeException {
    
    private String errorCode;
    private Object[] args;
    
    // Constructores
    public BusinessException(String message) {
        super(message);
    }
    
    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public BusinessException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    
    public BusinessException(String message, String errorCode, Object[] args) {
        super(message);
        this.errorCode = errorCode;
        this.args = args;
    }
    
    // Getters y Setters
    public String getErrorCode() {
        return errorCode;
    }
    
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
    
    public Object[] getArgs() {
        return args;
    }
    
    public void setArgs(Object[] args) {
        this.args = args;
    }
}