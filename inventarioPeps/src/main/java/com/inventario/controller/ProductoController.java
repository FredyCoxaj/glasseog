package com.inventario.controller;

import com.inventario.dto.ProductoBusquedaDTO;
import com.inventario.exception.BusinessException;
import com.inventario.model.Producto;
import com.inventario.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;
    
    @GetMapping("/buscar")
    public ResponseEntity<?> buscarProducto(@RequestParam(required = false) Integer idProducto,
                                            @RequestParam(required = false) String nombreMayusculas) {
        if (idProducto != null) {
            ProductoBusquedaDTO producto = productoService.buscarProductoConStock(idProducto);
            return ResponseEntity.ok(producto);
        } else if (nombreMayusculas != null) {
            Producto producto = productoService.buscarPorNombreExactoMayusculas(nombreMayusculas);
            ProductoBusquedaDTO productoConStock = productoService.buscarProductoConStock(producto.getIdProducto());
            return ResponseEntity.ok(productoConStock);
        } else {
            throw new BusinessException("Debe proporcionar idProducto o nombre en MAYUSCULAS");
        }
    }
    
    @GetMapping
    public ResponseEntity<List<Producto>> listarTodos() {
        return ResponseEntity.ok(productoService.listarTodos());
    }
    
    @GetMapping("/activos")
    public ResponseEntity<List<Producto>> listarActivos() {
        return ResponseEntity.ok(productoService.listarActivos());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ProductoBusquedaDTO> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(productoService.buscarProductoConStock(id));
    }
    
    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        Producto nuevoProducto = productoService.crearProducto(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Integer id, 
                                                        @RequestBody Producto producto) {
        Producto productoActualizado = productoService.actualizarProducto(id, producto);
        return ResponseEntity.ok(productoActualizado);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Integer id) {
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }
}