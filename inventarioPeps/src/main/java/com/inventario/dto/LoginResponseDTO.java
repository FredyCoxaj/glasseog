package com.inventario.dto;

public class LoginResponseDTO {
    
    private String token;
    private String rol;
    private String nombreCompleto;
    private Integer idUsuario;
    private String email;
    
    // Constructores
    public LoginResponseDTO() {}
    
    public LoginResponseDTO(String token, String rol, String nombreCompleto, Integer idUsuario) {
        this.token = token;
        this.rol = rol;
        this.nombreCompleto = nombreCompleto;
        this.idUsuario = idUsuario;
    }
    
    public LoginResponseDTO(String token, String rol, String nombreCompleto, Integer idUsuario, String email) {
        this.token = token;
        this.rol = rol;
        this.nombreCompleto = nombreCompleto;
        this.idUsuario = idUsuario;
        this.email = email;
    }
    
    // Getters y Setters
    public String getToken() {
        return token;
    }
    
    public void setToken(String token) {
        this.token = token;
    }
    
    public String getRol() {
        return rol;
    }
    
    public void setRol(String rol) {
        this.rol = rol;
    }
    
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    
    public Integer getIdUsuario() {
        return idUsuario;
    }
    
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
}