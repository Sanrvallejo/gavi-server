package com.gavi.server.dto;

import com.gavi.server.model.Producto;
import com.gavi.server.model.Venta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrearVentaDto {
    private Venta venta;
    private List<Producto> productos;
    private Double[] cantidades;

    public Double getCantidades(int j) {
        return cantidades[j];
    }
}
