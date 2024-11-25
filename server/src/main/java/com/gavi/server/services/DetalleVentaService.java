package com.gavi.server.services;

import com.gavi.server.model.DetalleVenta;
import com.gavi.server.model.Producto;
import com.gavi.server.model.Venta;
import com.gavi.server.repository.DetalleVentaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DetalleVentaService implements IDetalleVentaService {
    @Autowired
    DetalleVentaRespository detalleVentaRepository;

    @Override
    public DetalleVenta crearDetalleVenta(Producto producto, Double cantidad, Venta venta) {
        DetalleVenta detalleVenta = new DetalleVenta();
        detalleVenta.setProducto(producto);
        detalleVenta.setPrecioUnitario(producto.getPrecio());
        detalleVenta.setCantidad(cantidad);
        detalleVenta.setVenta(venta);
        detalleVenta.setSubtotal(producto.getPrecio()*cantidad);

        return detalleVentaRepository.save(detalleVenta);
    }

    @Override
    public List<DetalleVenta> obtenerDetallesVentasByVenta(Long idVenta) {
        List<DetalleVenta> detalleVentaList = detalleVentaRepository.findAll();

        if (idVenta!= null) {
            detalleVentaList = detalleVentaList.stream()
                    .filter(dv -> dv.getVenta().getId().equals(idVenta))
                    .collect(Collectors.toList());
        }

        return detalleVentaList;
    }
}
