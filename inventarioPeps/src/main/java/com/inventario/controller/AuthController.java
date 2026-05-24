package com.inventario.controller;

import com.inventario.dto.LoginRequestDTO;
import com.inventario.dto.LoginResponseDTO;
import com.inventario.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@Valid @RequestBody LoginRequestDTO request) {
        LoginResponseDTO response = usuarioService.login(request);
        return ResponseEntity.ok(response);
    }
}