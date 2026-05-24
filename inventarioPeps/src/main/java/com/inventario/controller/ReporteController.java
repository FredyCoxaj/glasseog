package com.inventario.controller;

import com.inventario.dto.ReporteVentasDTO;
import com.inventario.model.Lote;
import com.inventario.model.MovimientoInventario;
import com.inventario.model.Usuario;
import com.inventario.repository.DetalleVentaRepository;
import com.inventario.repository.LoteRepository;
import com.inventario.repository.MovimientoRepository;
import com.inventario.repository.VentaRepository;
import com.inventario.service.ReporteService;
import com.inventario.service.UsuarioService;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private LoteRepository loteRepository;

    @Autowired
    private MovimientoRepository movimientoRepository;


    @GetMapping("/ventas")
    public ResponseEntity<ReporteVentasDTO> generarReporteVentas(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fin) {
        ReporteVentasDTO reporte = reporteService.generarReporteVentas(inicio, fin);
        return ResponseEntity.ok(reporte);
    }

    @GetMapping("/usuarios/excel")
    public ResponseEntity<byte[]> exportarUsuariosExcel() {
        List<Usuario> usuarios = usuarioService.listarTodos();
        byte[] excelBytes = reporteService.exportarUsuariosExcel(usuarios);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "usuarios.xlsx");

        return ResponseEntity.ok()
                .headers(headers)
                .body(excelBytes);
    }
    // Productos mas vendidos

    @GetMapping("/top-productos")
    public ResponseEntity<List<Map<String, Object>>> getTopProductos() {
        List<Object[]> results = detalleVentaRepository.findProductosMasVendidos(); //<--error aqui
        List<Map<String, Object>> top = new ArrayList<>();
        for (int i = 0; i < Math.min(5, results.size()); i++) {
            Object[] row = results.get(i);
            Map<String, Object> item = new HashMap<>();
            item.put("nombre", row[0]);
            item.put("totalVendido", row[1]);
            top.add(item);
        }
        return ResponseEntity.ok(top);
    }

// Ventas por dia (ultimos 7 dias)
    @GetMapping("/ventas-por-dia")
    public ResponseEntity<List<Map<String, Object>>> getVentasPorDia() {
        LocalDate end = LocalDate.now();
        LocalDate start = end.minusDays(6);
        List<Map<String, Object>> result = new ArrayList<>();
        for (LocalDate date = start; !date.isAfter(end); date = date.plusDays(1)) {
            LocalDateTime inicio = date.atStartOfDay();
            LocalDateTime fin = date.plusDays(1).atStartOfDay();
            BigDecimal total = ventaRepository.sumVentasPorPeriodo(inicio, fin); //<--error aqui
            Map<String, Object> dayData = new HashMap<>();
            dayData.put("fecha", date.toString());
            dayData.put("total", total != null ? total : BigDecimal.ZERO);
            result.add(dayData);
        }
        return ResponseEntity.ok(result);
    }

// Valor del inventario (suma de cantidadDisponible * costoUnitarioCompra)
    @GetMapping("/valor-inventario")
    public ResponseEntity<BigDecimal> getValorInventario() {
        List<Lote> lotes = loteRepository.findAll(); 
        BigDecimal valor = lotes.stream()
                .filter(l -> l.getActivo() && l.getCantidadDisponible() > 0)
                .map(l -> l.getCostoUnitarioCompra().multiply(BigDecimal.valueOf(l.getCantidadDisponible())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return ResponseEntity.ok(valor);
    }

// Costo de bienes vendidos (COGS) = suma de (costo unitario * cantidad) de movimientos SALIDA
    @GetMapping("/cogs")
    public ResponseEntity<BigDecimal> getCOGS() {
        List<MovimientoInventario> salidas = movimientoRepository.findByTipoMovimiento("SALIDA"); //<--error aqui
        BigDecimal cogs = salidas.stream()
                .filter(m -> m.getLote() != null && m.getLote().getCostoUnitarioCompra() != null)
                .map(m -> m.getLote().getCostoUnitarioCompra().multiply(BigDecimal.valueOf(m.getCantidad())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return ResponseEntity.ok(cogs);
    }
}
