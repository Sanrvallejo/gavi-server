package com.gavi.server.repository;

import com.gavi.server.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> obtenerPorEmailAndPass(String email, String password);
}
