package com.gavi.server.services;

import com.gavi.server.model.Producto;
import com.gavi.server.model.Usuario;
import com.gavi.server.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Producto obtenerPorId(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Producto> obtenerProductos(Long idUsuario) {
        List<Producto> productList = productoRepository.findAll();

        if (idUsuario!= null) {
            productList = productList.stream()
                   .filter(p -> p.getPropietario().getId().equals(idUsuario))
                   .collect(Collectors.toList());
        }

        return productList;
    }

    @Override
    public Producto obtenerPorCodigo(String codigo) {
        return productoRepository.findByCodigo(codigo);
    }

    @Override
    public Producto obtenerPorNombre(String nombre) {
        return productoRepository.findByNombre(nombre);
    }

    @Override
    public Producto crearProducto(Usuario propietario, Producto nuevoProducto) {
        nuevoProducto.setNombre(nuevoProducto.getNombre().toUpperCase());
        nuevoProducto.setCategoria(nuevoProducto.getCategoria().toUpperCase());
        nuevoProducto.setPropietario(propietario);
        return productoRepository.save(nuevoProducto);
    }

    @Override
    public void editarProducto(String codigoProducto, Producto productoEditado) {
        Producto productoEncontrado = productoRepository.findByCodigo(codigoProducto);
        if (productoEncontrado!= null) {
            if (productoEncontrado.getCodigo() != null) {
                productoEncontrado.setCodigo(productoEditado.getCodigo());
            }

            if (productoEncontrado.getNombre() != null) {
                productoEncontrado.setNombre(productoEditado.getNombre().toUpperCase());
            }

            if (productoEncontrado.getCategoria() != null) {
                productoEncontrado.setCategoria(productoEditado.getCategoria().toUpperCase());
            }

            if (productoEncontrado.getPrecio() != null) {
                productoEncontrado.setPrecio(productoEditado.getPrecio());
            }

            if (productoEncontrado.getCantidad() != null) {
                productoEncontrado.setCantidad(productoEditado.getCantidad());
            }

            productoRepository.save(productoEncontrado);
        }else {
            System.out.println("No se pudo editar el producto");;
        }
    }

    @Override
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
}
