package com.inventario.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ReporteVentasDTO {
    
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private Long totalTransacciones;
    private BigDecimal montoTotal;
    private BigDecimal promedioPorVenta;
    private String productoMasVendido;
    private Integer cantidadProductoMasVendido;
    
    // Constructores
    public ReporteVentasDTO() {}
    
    // Getters y Setters
    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }
    
    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    
    public LocalDateTime getFechaFin() {
        return fechaFin;
    }
    
    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    public Long getTotalTransacciones() {
        return totalTransacciones;
    }
    
    public void setTotalTransacciones(Long totalTransacciones) {
        this.totalTransacciones = totalTransacciones;
    }
    
    public BigDecimal getMontoTotal() {
        return montoTotal;
    }
    
    public void setMontoTotal(BigDecimal montoTotal) {
        this.montoTotal = montoTotal;
    }
    
    public BigDecimal getPromedioPorVenta() {
        return promedioPorVenta;
    }
    
    public void setPromedioPorVenta(BigDecimal promedioPorVenta) {
        this.promedioPorVenta = promedioPorVenta;
    }
    
    public String getProductoMasVendido() {
        return productoMasVendido;
    }
    
    public void setProductoMasVendido(String productoMasVendido) {
        this.productoMasVendido = productoMasVendido;
    }
    
    public Integer getCantidadProductoMasVendido() {
        return cantidadProductoMasVendido;
    }
    
    public void setCantidadProductoMasVendido(Integer cantidadProductoMasVendido) {
        this.cantidadProductoMasVendido = cantidadProductoMasVendido;
    }
}