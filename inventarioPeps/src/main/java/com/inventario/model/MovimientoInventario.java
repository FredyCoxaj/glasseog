package com.inventario.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "movimiento_inventario")
public class MovimientoInventario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimiento")
    private Integer idMovimiento;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_lote", nullable = false)
    private Lote lote;
    
    @Column(name = "tipo_movimiento", nullable = false, length = 10)
    private String tipoMovimiento;
    
    @Column(nullable = false)
    private Integer cantidad;
    
    @Column(name = "fecha_movimiento")
    private LocalDateTime fechaMovimiento = LocalDateTime.now();
    
    @Column(name = "usuario_responsable_id", nullable = false)
    private Integer usuarioResponsableId;
    
    @Column(length = 100)
    private String referencia;
    
    private String observacion;
    
    // Constructor
    public MovimientoInventario() {}
    
    
    public Integer getIdMovimiento() {
        return idMovimiento;
    }
    
    public void setIdMovimiento(Integer idMovimiento) {
        this.idMovimiento = idMovimiento;
    }
    
    public Lote getLote() {
        return lote;
    }
    
    public void setLote(Lote lote) {
        this.lote = lote;
    }
    
    public String getTipoMovimiento() {
        return tipoMovimiento;
    }
    
    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }
    
    public Integer getCantidad() {
        return cantidad;
    }
    
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
    public LocalDateTime getFechaMovimiento() {
        return fechaMovimiento;
    }
    
    public void setFechaMovimiento(LocalDateTime fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }
    
    public Integer getUsuarioResponsableId() {
        return usuarioResponsableId;
    }
    
    public void setUsuarioResponsableId(Integer usuarioResponsableId) {
        this.usuarioResponsableId = usuarioResponsableId;
    }
    
    public String getReferencia() {
        return referencia;
    }
    
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
    
    public String getObservacion() {
        return observacion;
    }
    
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}