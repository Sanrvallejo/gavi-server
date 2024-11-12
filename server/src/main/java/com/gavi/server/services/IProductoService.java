package com.gavi.server.services;

import com.gavi.server.model.Producto;

import java.util.List;

public interface IProductoService {
    Producto obtenerPorId(Long id);

    List<Producto> obtenerProductos();

    Producto obtenerPorCodigo(String codigo);

    Producto obtenerPorNombre(String nombre);

    Producto crearProducto(Producto nuevoProducto);

    void editarProducto(Long id, Producto productoEditado);

    void eliminarProducto(Long id);
}
