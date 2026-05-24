package com.inventario.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LoteRequestDTO {
    
    @NotNull(message = "El ID del producto es obligatorio")
    private Integer idProducto;
    
    private Integer idProveedor;
    
    private String codigoLoteExterno;
    
    @NotNull(message = "La cantidad es obligatoria")
    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    private Integer cantidad;
    
    @NotNull(message = "El costo unitario es obligatorio")
    @Min(value = 0, message = "El costo unitario debe ser mayor o igual a 0")
    private BigDecimal costoUnitario;
    
    @NotNull(message = "La fecha de caducidad es obligatoria")
    private LocalDate fechaCaducidad;
    
    // Constructores
    public LoteRequestDTO() {}
    
    // Getters y Setters
    public Integer getIdProducto() {
        return idProducto;
    }
    
    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
    
    public Integer getIdProveedor() {
        return idProveedor;
    }
    
    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }
    
    public String getCodigoLoteExterno() {
        return codigoLoteExterno;
    }
    
    public void setCodigoLoteExterno(String codigoLoteExterno) {
        this.codigoLoteExterno = codigoLoteExterno;
    }
    
    public Integer getCantidad() {
        return cantidad;
    }
    
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
    public BigDecimal getCostoUnitario() {
        return costoUnitario;
    }
    
    public void setCostoUnitario(BigDecimal costoUnitario) {
        this.costoUnitario = costoUnitario;
    }
    
    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }
    
    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }
}