package com.gavi.server.repository;

import com.gavi.server.model.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleVentaRespository extends JpaRepository<DetalleVenta, Long> {
}
