package com.gavi.server.services;

import com.gavi.server.model.Usuario;
import com.gavi.server.model.Venta;

import java.util.Date;
import java.util.List;

public interface IVentaService {
    Venta crearVenta(Venta venta, Long vendedor);

    Venta obtenerVentaById(Long id);

    List<Venta> obtenerVentasByVendedor(Long idUsuario);

    void eliminarVenta(Integer id);
}
