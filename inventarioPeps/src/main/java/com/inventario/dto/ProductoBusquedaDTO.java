package com.inventario.dto;

import java.math.BigDecimal;

public class ProductoBusquedaDTO {
    
    private Integer idProducto;
    private String nombre;
    private String descripcion;
    private BigDecimal precioBaseCompra;
    private BigDecimal precioVentaSugerido;
    private Integer stockDisponible;
    private Boolean enOferta;
    
    // Constructores
    public ProductoBusquedaDTO() {}
    
    public ProductoBusquedaDTO(Integer idProducto, String nombre, String descripcion, 
                               BigDecimal precioBaseCompra, BigDecimal precioVentaSugerido, 
                               Integer stockDisponible, Boolean enOferta) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioBaseCompra = precioBaseCompra;
        this.precioVentaSugerido = precioVentaSugerido;
        this.stockDisponible = stockDisponible;
        this.enOferta = enOferta;
    }
    
    // Getters y Setters
    public Integer getIdProducto() {
        return idProducto;
    }
    
    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public BigDecimal getPrecioBaseCompra() {
        return precioBaseCompra;
    }
    
    public void setPrecioBaseCompra(BigDecimal precioBaseCompra) {
        this.precioBaseCompra = precioBaseCompra;
    }
    
    public BigDecimal getPrecioVentaSugerido() {
        return precioVentaSugerido;
    }
    
    public void setPrecioVentaSugerido(BigDecimal precioVentaSugerido) {
        this.precioVentaSugerido = precioVentaSugerido;
    }
    
    public Integer getStockDisponible() {
        return stockDisponible;
    }
    
    public void setStockDisponible(Integer stockDisponible) {
        this.stockDisponible = stockDisponible;
    }
    
    public Boolean getEnOferta() {
        return enOferta;
    }
    
    public void setEnOferta(Boolean enOferta) {
        this.enOferta = enOferta;
    }
}