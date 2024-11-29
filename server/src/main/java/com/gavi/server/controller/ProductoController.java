package com.gavi.server.controller;

import com.gavi.server.model.Producto;
import com.gavi.server.model.Usuario;
import com.gavi.server.services.IProductoService;
import com.gavi.server.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gavi")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/productos/{idUsuario}")
    public ResponseEntity<List<Producto>> obtenerProductos(@PathVariable Long idUsuario) {
        List<Producto> listaProductos = productoService.obtenerProductos(idUsuario);

        if (listaProductos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(listaProductos);
    }

    @PostMapping("/nuevo-producto/{idUsuario}")
    public ResponseEntity<Producto> crearProducto(
            @RequestBody Producto producto,
            @PathVariable Long idUsuario
    ) {
        try {
            Usuario usuarioEncontrado = usuarioService.obtenerUsuarioPorId(idUsuario).get();
            Producto nuevoProducto = productoService.crearProducto(usuarioEncontrado, producto);
            return ResponseEntity.ok().body(nuevoProducto);

        }catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/producto-editado/{codigoProducto}")
    public void editarProducto(
            @PathVariable String codigoProducto,
            @RequestBody Producto productoEditado
    ) {
        productoService.editarProducto(codigoProducto, productoEditado);
    }

    @DeleteMapping("/eliminar-producto/{idProducto}")
    public void eliminarProducto(@PathVariable Long idProducto) {
        productoService.eliminarProducto(idProducto);
    }
}
