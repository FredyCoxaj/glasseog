package com.inventario.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "detalle_venta")
public class DetalleVenta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Integer idDetalle;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_venta", nullable = false)
    private Venta venta;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_lote", nullable = false)
    private Lote lote;
    
    @Column(nullable = false)
    private Integer cantidad;
    
    @Column(name = "precio_unitario_venta", nullable = false, precision = 12, scale = 2)
    private BigDecimal precioUnitarioVenta;
    
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal subtotal;
    
    // Constructores
    public DetalleVenta() {}
    
    // Getters y Setters
    public Integer getIdDetalle() {
        return idDetalle;
    }
    
    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }
    
    public Venta getVenta() {
        return venta;
    }
    
    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    
    public Lote getLote() {
        return lote;
    }
    
    public void setLote(Lote lote) {
        this.lote = lote;
    }
    
    public Integer getCantidad() {
        return cantidad;
    }
    
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
    public BigDecimal getPrecioUnitarioVenta() {
        return precioUnitarioVenta;
    }
    
    public void setPrecioUnitarioVenta(BigDecimal precioUnitarioVenta) {
        this.precioUnitarioVenta = precioUnitarioVenta;
    }
    
    public BigDecimal getSubtotal() {
        return subtotal;
    }
    
    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
}