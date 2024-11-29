package com.gavi.server.services;

import com.gavi.server.dto.CrearVentaDto;
import com.gavi.server.model.Venta;

import java.util.List;

public interface IVentaService {
    Venta crearVenta(CrearVentaDto ventaDto, Long idVendedor);

    Venta obtenerVentaById(Long id);

    List<Venta> obtenerVentasByVendedor(Long idUsuario);

    void eliminarVenta(Integer id);
}
