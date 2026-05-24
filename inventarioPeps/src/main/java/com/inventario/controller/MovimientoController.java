package com.inventario.controller;

import com.inventario.model.MovimientoInventario;
import com.inventario.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/movimientos")
public class MovimientoController {
    
    @Autowired
    private MovimientoService movimientoService;
    
    @GetMapping
    public ResponseEntity<List<MovimientoInventario>> listarTodos() {
        return ResponseEntity.ok(movimientoService.listarTodos());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<MovimientoInventario> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(movimientoService.buscarPorId(id));
    }
    
    @GetMapping("/lote/{idLote}")
    public ResponseEntity<List<MovimientoInventario>> buscarPorLote(@PathVariable Integer idLote) {
        return ResponseEntity.ok(movimientoService.buscarPorLote(idLote));
    }
    
    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<MovimientoInventario>> buscarPorTipo(@PathVariable String tipo) {
        return ResponseEntity.ok(movimientoService.buscarPorTipo(tipo));
    }
    
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<MovimientoInventario>> buscarPorUsuario(@PathVariable Integer usuarioId) {
        return ResponseEntity.ok(movimientoService.buscarPorUsuario(usuarioId));
    }
    
    @GetMapping("/fechas")
    public ResponseEntity<List<MovimientoInventario>> buscarPorRangoFechas(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fin) {
        return ResponseEntity.ok(movimientoService.buscarPorRangoFechas(inicio, fin));
    }
    
    @GetMapping("/tipo-fecha")
    public ResponseEntity<List<MovimientoInventario>> buscarPorTipoYFecha(
            @RequestParam String tipo,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fin) {
        return ResponseEntity.ok(movimientoService.buscarPorTipoYFecha(tipo, inicio, fin));
    }
    
    @GetMapping("/historial")
    public ResponseEntity<List<MovimientoInventario>> getHistorialMovimientos() {
        return ResponseEntity.ok(movimientoService.getHistorialMovimientos());
    }
    
    @GetMapping("/referencia")
    public ResponseEntity<List<MovimientoInventario>> buscarPorReferencia(@RequestParam String referencia) {
        return ResponseEntity.ok(movimientoService.buscarPorReferencia(referencia));
    }
    
    @PostMapping("/entrada")
    public ResponseEntity<MovimientoInventario> registrarEntrada(
            @RequestParam Integer idLote,
            @RequestParam Integer cantidad,
            @RequestAttribute("idUsuario") Integer usuarioResponsableId,
            @RequestParam(required = false) String referencia) {
        MovimientoInventario movimiento = movimientoService.registrarEntrada(idLote, cantidad, usuarioResponsableId, referencia);
        return ResponseEntity.ok(movimiento);
    }
    
    @PostMapping("/salida")
    public ResponseEntity<MovimientoInventario> registrarSalida(
            @RequestParam Integer idLote,
            @RequestParam Integer cantidad,
            @RequestAttribute("idUsuario") Integer usuarioResponsableId,
            @RequestParam(required = false) String referencia) {
        MovimientoInventario movimiento = movimientoService.registrarSalida(idLote, cantidad, usuarioResponsableId, referencia);
        return ResponseEntity.ok(movimiento);
    }
}