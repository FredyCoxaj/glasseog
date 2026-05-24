package com.inventario.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "venta")
public class Venta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Integer idVenta;
    
    @Column(name = "fecha_venta")
    private LocalDateTime fechaVenta = LocalDateTime.now();
    
    @Column(name = "id_vendedor", nullable = false)
    private Integer idVendedor;
    
    @Column(name = "nombre_comprador", nullable = false, length = 100)
    private String nombreComprador;
    
    @Column(name = "direccion_comprador", nullable = false, length = 200)
    private String direccionComprador;
    
    @Column(name = "telefono_comprador", nullable = false, length = 20)
    private String telefonoComprador;
    
    @Column(name = "tipo_pago", nullable = false, length = 30)
    private String tipoPago;
    
    @Column(name = "monto_total", nullable = false, precision = 12, scale = 2)
    private BigDecimal montoTotal;
    
    private Boolean anulada = false;
    
    // Constructores
    public Venta() {}
    
    // Getters y Setters
    public Integer getIdVenta() {
        return idVenta;
    }
    
    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }
    
    public LocalDateTime getFechaVenta() {
        return fechaVenta;
    }
    
    public void setFechaVenta(LocalDateTime fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
    
    public Integer getIdVendedor() {
        return idVendedor;
    }
    
    public void setIdVendedor(Integer idVendedor) {
        this.idVendedor = idVendedor;
    }
    
    public String getNombreComprador() {
        return nombreComprador;
    }
    
    public void setNombreComprador(String nombreComprador) {
        this.nombreComprador = nombreComprador;
    }
    
    public String getDireccionComprador() {
        return direccionComprador;
    }
    
    public void setDireccionComprador(String direccionComprador) {
        this.direccionComprador = direccionComprador;
    }
    
    public String getTelefonoComprador() {
        return telefonoComprador;
    }
    
    public void setTelefonoComprador(String telefonoComprador) {
        this.telefonoComprador = telefonoComprador;
    }
    
    public String getTipoPago() {
        return tipoPago;
    }
    
    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }
    
    public BigDecimal getMontoTotal() {
        return montoTotal;
    }
    
    public void setMontoTotal(BigDecimal montoTotal) {
        this.montoTotal = montoTotal;
    }
    
    public Boolean getAnulada() {
        return anulada;
    }
    
    public void setAnulada(Boolean anulada) {
        this.anulada = anulada;
    }
}