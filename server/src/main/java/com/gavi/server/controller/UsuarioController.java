package com.gavi.server.controller;

import com.gavi.server.model.Usuario;
import com.gavi.server.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gavi")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable Long id) {
        return usuarioService.obtenerUsuarioPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> obtenerUsuarios() {
        List<Usuario> listaUsarios = usuarioService.obtenerUsuarios();

        if (listaUsarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(listaUsarios);
    }

    @PostMapping("/nuevo-usuario")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.crearUsuario(usuario);
        return ResponseEntity.ok().body(nuevoUsuario);
    }

    @PutMapping("/usuario-editado/{id}")
    public ResponseEntity<Usuario> editarUsuario(
            @PathVariable Long id,
            @RequestBody Usuario usuario
    ) {
        Usuario usuarioEditado  = usuarioService.actualizarUsuario(id, usuario);

        if (usuarioEditado != null) {
            return ResponseEntity.ok().body(usuarioEditado);
        }else  {
            return ResponseEntity.notFound().build();
        }
    }
}
