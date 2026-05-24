package com.inventario.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

public class VentaRequestDTO {
    
    @NotBlank(message = "El nombre del comprador es obligatorio")
    private String nombreComprador;
    
    @NotBlank(message = "La dirección del comprador es obligatoria")
    private String direccionComprador;
    
    @NotBlank(message = "El teléfono del comprador es obligatorio")
    private String telefonoComprador;
    
    @NotBlank(message = "El tipo de pago es obligatorio")
    private String tipoPago;
    
    @NotNull(message = "Debe incluir al menos un producto")
    @Size(min = 1, message = "Debe incluir al menos un producto")
    @Valid
    private List<ItemVentaDTO> items;
    
    // Constructores
    public VentaRequestDTO() {}
    
    // Getters y Setters
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
    
    public List<ItemVentaDTO> getItems() {
        return items;
    }
    
    public void setItems(List<ItemVentaDTO> items) {
        this.items = items;
    }
}