package com.inventario.model;

import jakarta.persistence.*;

@Entity
@Table(name = "proveedor")
public class Proveedor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Integer idProveedor;
    
    @Column(name = "nombre_empresa", nullable = false, length = 100)
    private String nombreEmpresa;
    
    @Column(name = "contacto_nombre", length = 100)
    private String contactoNombre;
    
    @Column(name = "contacto_telefono", length = 20)
    private String contactoTelefono;
    
    @Column(length = 200)
    private String direccion;
    
    // Constructores
    public Proveedor() {}
    
    public Proveedor(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
    
    // Getters y Setters
    public Integer getIdProveedor() {
        return idProveedor;
    }
    
    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }
    
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }
    
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
    
    public String getContactoNombre() {
        return contactoNombre;
    }
    
    public void setContactoNombre(String contactoNombre) {
        this.contactoNombre = contactoNombre;
    }
    
    public String getContactoTelefono() {
        return contactoTelefono;
    }
    
    public void setContactoTelefono(String contactoTelefono) {
        this.contactoTelefono = contactoTelefono;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}