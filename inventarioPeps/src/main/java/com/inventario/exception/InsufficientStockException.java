package com.inventario.exception;

public class InsufficientStockException extends RuntimeException {
    
    private Integer productId;
    private String productName;
    private Integer requestedQuantity;
    private Integer availableQuantity;
    
    // Constructores
    public InsufficientStockException(String message) {
        super(message);
    }
    
    public InsufficientStockException(Integer productId, String productName, 
                                      Integer requestedQuantity, Integer availableQuantity) {
        super(String.format("Stock insuficiente para producto '%s' (ID: %d). " +
              "Solicitado: %d, Disponible: %d", productName, productId, requestedQuantity, availableQuantity));
        this.productId = productId;
        this.productName = productName;
        this.requestedQuantity = requestedQuantity;
        this.availableQuantity = availableQuantity;
    }
    
    // Getters y Setters
    public Integer getProductId() {
        return productId;
    }
    
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    
    public String getProductName() {
        return productName;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    public Integer getRequestedQuantity() {
        return requestedQuantity;
    }
    
    public void setRequestedQuantity(Integer requestedQuantity) {
        this.requestedQuantity = requestedQuantity;
    }
    
    public Integer getAvailableQuantity() {
        return availableQuantity;
    }
    
    public void setAvailableQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
    }
}