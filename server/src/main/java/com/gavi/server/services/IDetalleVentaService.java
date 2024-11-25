package com.gavi.server.services;

import com.gavi.server.model.DetalleVenta;
import com.gavi.server.model.Producto;
import com.gavi.server.model.Venta;

import java.util.List;

public interface IDetalleVentaService {
    DetalleVenta crearDetalleVenta(Producto producto, Double cantidad, Venta venta);

    List<DetalleVenta> obtenerDetallesVentasByVenta(Venta venta);
}
