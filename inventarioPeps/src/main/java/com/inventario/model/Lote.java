package com.inventario.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "lote")
public class Lote {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lote")
    private Integer idLote;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_proveedor")
    private Proveedor proveedor;
    
    @Column(name = "codigo_lote_externo", length = 50)
    private String codigoLoteExterno;
    
    @Column(name = "cantidad_ingresada", nullable = false)
    private Integer cantidadIngresada;
    
    @Column(name = "cantidad_disponible", nullable = false)
    private Integer cantidadDisponible;
    
    @Column(name = "costo_unitario_compra", nullable = false, precision = 12, scale = 2)
    private BigDecimal costoUnitarioCompra;
    
    @Column(name = "fecha_ingreso")
    private LocalDateTime fechaIngreso = LocalDateTime.now();
    
    @Column(name = "fecha_caducidad", nullable = false)
    private LocalDate fechaCaducidad;
    
    @Column(name = "en_oferta")
    private Boolean enOferta = false;
    
    @Column(name = "porcentaje_descuento_oferta", precision = 5, scale = 2)
    private BigDecimal porcentajeDescuentoOferta = BigDecimal.ZERO;
    
    private Boolean activo = true;
    
    // Constructores
    public Lote() {}
    
    // Getters y Setters
    public Integer getIdLote() {
        return idLote;
    }
    
    public void setIdLote(Integer idLote) {
        this.idLote = idLote;
    }
    
    public Producto getProducto() {
        return producto;
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    public Proveedor getProveedor() {
        return proveedor;
    }
    
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    
    public String getCodigoLoteExterno() {
        return codigoLoteExterno;
    }
    
    public void setCodigoLoteExterno(String codigoLoteExterno) {
        this.codigoLoteExterno = codigoLoteExterno;
    }
    
    public Integer getCantidadIngresada() {
        return cantidadIngresada;
    }
    
    public void setCantidadIngresada(Integer cantidadIngresada) {
        this.cantidadIngresada = cantidadIngresada;
    }
    
    public Integer getCantidadDisponible() {
        return cantidadDisponible;
    }
    
    public void setCantidadDisponible(Integer cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }
    
    public BigDecimal getCostoUnitarioCompra() {
        return costoUnitarioCompra;
    }
    
    public void setCostoUnitarioCompra(BigDecimal costoUnitarioCompra) {
        this.costoUnitarioCompra = costoUnitarioCompra;
    }
    
    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }
    
    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    
    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }
    
    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }
    
    public Boolean getEnOferta() {
        return enOferta;
    }
    
    public void setEnOferta(Boolean enOferta) {
        this.enOferta = enOferta;
    }
    
    public BigDecimal getPorcentajeDescuentoOferta() {
        return porcentajeDescuentoOferta;
    }
    
    public void setPorcentajeDescuentoOferta(BigDecimal porcentajeDescuentoOferta) {
        this.porcentajeDescuentoOferta = porcentajeDescuentoOferta;
    }
    
    public Boolean getActivo() {
        return activo;
    }
    
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}