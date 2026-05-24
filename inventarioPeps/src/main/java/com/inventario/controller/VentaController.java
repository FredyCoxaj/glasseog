package com.inventario.controller;

import com.inventario.dto.VentaRequestDTO;
import com.inventario.model.Venta;
import com.inventario.service.VentaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {
    
    @Autowired
    private VentaService ventaService;
    
    @PostMapping
    public ResponseEntity<Venta> registrarVenta(@Valid @RequestBody VentaRequestDTO request,
                                                 @RequestAttribute("idUsuario") Integer vendedorId) {
        Venta nuevaVenta = ventaService.registrarVenta(request, vendedorId);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaVenta);
    }
    
    @GetMapping
    public ResponseEntity<List<Venta>> listarVentas() {
        return ResponseEntity.ok(ventaService.obtenerHistorialVentas());
    }
    
    @GetMapping("/vendedor/{vendedorId}")
    public ResponseEntity<List<Venta>> listarVentasPorVendedor(@PathVariable Integer vendedorId) {
        return ResponseEntity.ok(ventaService.obtenerVentasPorVendedor(vendedorId));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Venta> obtenerVentaPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(ventaService.obtenerVentaPorId(id));
    }
    
    @GetMapping("/total-general")
    public ResponseEntity<BigDecimal> getTotalVentasGenerales() {
        return ResponseEntity.ok(ventaService.getTotalVentasGenerales());
    }
}