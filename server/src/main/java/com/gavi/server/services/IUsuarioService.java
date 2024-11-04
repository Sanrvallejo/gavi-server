package com.gavi.server.services;

import com.gavi.server.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {

    Usuario crearUsuario(Usuario usuario);

    Optional<Usuario> obtenerUsuarioPorId(Long id);

    List<Usuario> obtenerUsuarios();

    Usuario actualizarUsuario(Long id, Usuario usuario);

    void eliminarUsuario(Long id);
}
