package com.gavi.server.controller;

import com.gavi.server.dto.LoginDto;
import com.gavi.server.model.Usuario;
import com.gavi.server.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/gavi")
public class AuthController {
    @Autowired
    private IUsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody LoginDto loginDto){
        Optional<Usuario> usuarioEncontrado = usuarioService.obtenerPorEmailAndPass(loginDto.getEmail(), loginDto.getPassword());

        if (usuarioEncontrado.isPresent()) {
            return ResponseEntity.ok(usuarioEncontrado.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
