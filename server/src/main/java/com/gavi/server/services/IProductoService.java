package com.gavi.server.services;

import com.gavi.server.model.Producto;
import com.gavi.server.model.Usuario;

import java.util.List;

public interface IProductoService {
    Producto obtenerPorId(Long id);

    List<Producto> obtenerProductos(Long idUsuario);

    Producto obtenerPorCodigo(String codigo);

    Producto obtenerPorNombre(String nombre);

    Producto crearProducto(Usuario propietario, Producto nuevoProducto);

    void editarProducto(String codigoProducto, Producto productoEditado);

    void eliminarProducto(Long id);
}
