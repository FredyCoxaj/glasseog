package com.inventario.controller;

import com.inventario.dto.LoteRequestDTO;
import com.inventario.model.Lote;
import com.inventario.service.LoteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/lotes")
public class LoteController {
    
    @Autowired
    private LoteService loteService;
    
    @PostMapping("/ingresar")
    public ResponseEntity<Lote> ingresarMercaderia(@Valid @RequestBody LoteRequestDTO request,
                                                    @RequestAttribute("idUsuario") Integer usuarioResponsableId) {
        Lote nuevoLote = loteService.ingresarMercaderia(request, usuarioResponsableId);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoLote);
    }
    
    @GetMapping
    public ResponseEntity<List<Lote>> verLotesExistentes() {
        return ResponseEntity.ok(loteService.verLotesExistentes());
    }
    
    @GetMapping("/producto/{idProducto}")
    public ResponseEntity<List<Lote>> verLotesPorProducto(@PathVariable Integer idProducto) {
        return ResponseEntity.ok(loteService.verLotesPorProducto(idProducto));
    }
    
    @GetMapping("/proximos-vencer")
    public ResponseEntity<List<Lote>> verLotesProximosVencer() {
        return ResponseEntity.ok(loteService.verLotesProximosVencer());
    }
    
    @GetMapping("/stock-bajo")
    public ResponseEntity<List<Lote>> verProductosStockBajo() {
        return ResponseEntity.ok(loteService.verProductosConStockBajo());
    }
    
    @GetMapping("/ofertas")
    public ResponseEntity<List<Lote>> verLotesEnOferta() {
        return ResponseEntity.ok(loteService.verLotesEnOferta());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Lote> buscarLotePorId(@PathVariable Integer id) {
        return ResponseEntity.ok(loteService.buscarLotePorId(id));
    }
    
    @PostMapping("/actualizar-ofertas")
    public ResponseEntity<String> actualizarOfertasAutomaticas() {
        loteService.actualizarOfertasAutomaticas();
        return ResponseEntity.ok("Ofertas actualizadas automaticamente");
    }
}