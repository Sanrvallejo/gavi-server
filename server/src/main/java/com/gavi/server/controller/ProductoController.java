package com.gavi.server.controller;

import com.gavi.server.model.Producto;
import com.gavi.server.services.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/gavi")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @GetMapping("/productos")
    public ResponseEntity<List<Producto>> obtenerProductos() {
        List<Producto> listaProductos = productoService.obtenerProductos();

        if (listaProductos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(listaProductos);
    }

    @PostMapping("/nuevo-producto")
    public ResponseEntity<Producto> crearProducto(Producto producto) {
        Producto nuevoProducto = productoService.crearProducto(producto);
        return ResponseEntity.ok().body(nuevoProducto);
    }
}
