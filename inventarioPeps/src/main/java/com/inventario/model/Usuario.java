package com.inventario.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuario")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    
    @Column(name = "nombre_completo", nullable = false, length = 100)
    private String nombreCompleto;
    
    @Column(nullable = false, unique = true, length = 100)
    private String email;
    
    @Column(name = "contrasena_hash", nullable = false)
    private String contrasenaHash;
    
    @Column(name = "carnet_identidad", nullable = false, length = 20)
    private String carnetIdentidad;
    
    @Column(length = 20)
    private String telefono;
    
    @Column(length = 200)
    private String direccion;
    
    @Column(nullable = false, length = 20)
    private String rol;
    
    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;
    
    // Constructores
    public Usuario() {
        this.fechaRegistro = LocalDateTime.now();
    }
    
    public Usuario(String nombreCompleto, String email, String contrasenaHash, 
                   String carnetIdentidad, String rol) {
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.contrasenaHash = contrasenaHash;
        this.carnetIdentidad = carnetIdentidad;
        this.rol = rol;
        this.fechaRegistro = LocalDateTime.now();
    }
    
    // Getters y Setters
    public Integer getIdUsuario() {
        return idUsuario;
    }
    
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getContrasenaHash() {
        return contrasenaHash;
    }
    
    public void setContrasenaHash(String contrasenaHash) {
        this.contrasenaHash = contrasenaHash;
    }
    
    public String getCarnetIdentidad() {
        return carnetIdentidad;
    }
    
    public void setCarnetIdentidad(String carnetIdentidad) {
        this.carnetIdentidad = carnetIdentidad;
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public String getRol() {
        return rol;
    }
    
    public void setRol(String rol) {
        this.rol = rol;
    }
    
    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }
    
    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}