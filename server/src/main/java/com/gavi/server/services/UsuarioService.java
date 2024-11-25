package com.gavi.server.services;

import com.gavi.server.model.Usuario;
import com.gavi.server.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements  IUsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        usuario.setNombre(usuario.getNombre().toUpperCase());
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Optional<Usuario> obtenerPorEmailAndPass(String email, String password) {
        return usuarioRepository.findByEmailAndAndPassword(email, password);
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario actualizarUsuario(Long id, Usuario usuario) {
        Usuario usuarioEncontrado = usuarioRepository.findById(id).orElse(null);
        if (usuarioEncontrado!= null) {
            if (usuario.getNombre() != null || usuario.getNombre().equalsIgnoreCase("")) {
                usuarioEncontrado.setNombre(usuario.getNombre());
            }

            if (usuario.getEmail() != null || usuario.getEmail().equalsIgnoreCase("")) {
                usuarioEncontrado.setEmail(usuario.getEmail());
            }

            if (usuario.getPassword() != null || usuario.getPassword().equalsIgnoreCase("")) {
                usuarioEncontrado.setPassword(usuario.getPassword());
            }

            //TODO: cambiar los || por &&
            return usuarioRepository.save(usuarioEncontrado);
        }else {
            System.out.println("No se pudo editar el usuario");
            return null;
        }
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
