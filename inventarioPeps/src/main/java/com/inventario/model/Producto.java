package com.inventario.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "producto")
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;
    
    @Column(nullable = false, length = 100)
    private String nombre;
    
    @Column(columnDefinition = "TEXT")
    private String descripcion;
    
    @Column(name = "precio_base_compra", nullable = false, precision = 12, scale = 2)
    private BigDecimal precioBaseCompra;
    
    @Column(name = "margen_ganancia_porcentual", precision = 5, scale = 2)
    private BigDecimal margenGananciaPorcentual = new BigDecimal("15.00");
    
    private Boolean activo = true;
    
    // Constructores
    public Producto() {}
    
    public Producto(String nombre, BigDecimal precioBaseCompra) {
        this.nombre = nombre;
        this.precioBaseCompra = precioBaseCompra;
    }
    
    // Método para calcular precio de venta sugerido
    public BigDecimal getPrecioVentaSugerido() {
        if (precioBaseCompra == null || margenGananciaPorcentual == null) {
            return BigDecimal.ZERO;
        }
        BigDecimal margen = margenGananciaPorcentual.divide(new BigDecimal("100"), 4, java.math.RoundingMode.HALF_UP);
        return precioBaseCompra.multiply(BigDecimal.ONE.add(margen));
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
    
    public BigDecimal getMargenGananciaPorcentual() {
        return margenGananciaPorcentual;
    }
    
    public void setMargenGananciaPorcentual(BigDecimal margenGananciaPorcentual) {
        this.margenGananciaPorcentual = margenGananciaPorcentual;
    }
    
    public Boolean getActivo() {
        return activo;
    }
    
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}