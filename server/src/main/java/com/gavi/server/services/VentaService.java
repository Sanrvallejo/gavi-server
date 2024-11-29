package com.gavi.server.services;

import com.gavi.server.dto.CrearVentaDto;
import com.gavi.server.model.DetalleVenta;
import com.gavi.server.model.Producto;
import com.gavi.server.model.Usuario;
import com.gavi.server.model.Venta;
import com.gavi.server.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VentaService implements IVentaService {
    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private DetalleVentaService detalleVentaService;

    @Override
    public Venta crearVenta(CrearVentaDto ventaDto, Long idVendedor) {
        Usuario usuarioEncontrado = usuarioService.obtenerUsuarioPorId(idVendedor).orElse(null);

        Venta v = null;

        if (usuarioEncontrado != null) {
            double subtotal = 0;
            Venta venta = ventaDto.getVenta();
            venta.setFecha(new Date());
            venta.setVendedor(usuarioEncontrado);
            v = ventaRepository.save(venta);

            for (int j = 0; j < ventaDto.getProductos().size(); j++) {
                Producto p = productoService.obtenerPorId(ventaDto.getProductos().get(j).getId());
                Double cantidad = ventaDto.getCantidades(j);

                DetalleVenta detalleVenta = detalleVentaService.crearDetalleVenta(p, cantidad, v);
                subtotal += detalleVenta.getSubtotal();
                productoService.calcularCantidad(p, cantidad);
            }
            v.setTotal(subtotal);
            ventaRepository.save(v);
        } else {
            System.out.println("No se encontro el cliente");
        }

        return v;
    }

    @Override
    public Venta obtenerVentaById(Long id) {
        return ventaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Venta> obtenerVentasByVendedor(Long idUsuario) {
        List<Venta> ventasList = ventaRepository.findAll();

        if (idUsuario != null) {
            ventasList = ventasList.stream()
                    .filter(v -> v.getVendedor().getId().equals(idUsuario))
                    .collect(Collectors.toList());
        }

        return ventasList;
    }

    @Override
    public void eliminarVenta(Integer id) {

    }
}
