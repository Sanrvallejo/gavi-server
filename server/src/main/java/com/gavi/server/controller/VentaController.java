package com.gavi.server.controller;

import com.gavi.server.dto.CrearVentaDto;
import com.gavi.server.model.Venta;
import com.gavi.server.services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gavi")
public class VentaController {
    @Autowired
    private VentaService ventaService;

    @GetMapping("/ventas/{idUsuario}")
    public ResponseEntity<List<Venta>> obtenerVentasPorUsuario(@PathVariable Long idUsuario) {
        List<Venta> listaVentas = ventaService.obtenerVentasByVendedor(idUsuario);

        if (listaVentas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(listaVentas);
    }

    @PostMapping("/nueva-venta/{idUsuario}")
    public ResponseEntity<Venta> crearVenta(
            @PathVariable Long idUsuario,
            @RequestBody CrearVentaDto ventaDto
            ) {
        Venta ventaCreada = ventaService.crearVenta(ventaDto, idUsuario);

        if (ventaCreada != null) {
            return ResponseEntity.ok(ventaCreada);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
