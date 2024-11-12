package com.gavi.server.repository;

import com.gavi.server.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    Producto obtenerPorCodigo(String codigo);

    Producto obtenerPorNombre(String nombre);
}
