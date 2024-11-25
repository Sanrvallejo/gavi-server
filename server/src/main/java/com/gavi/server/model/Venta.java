package com.gavi.server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name= "ventas")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    private double total;

    @Column(unique = true)
    private String codigo;

    private String metodoPago;

    @ManyToOne
    @JoinColumn (name = "usuario_id")
    @JsonIgnore
    private Usuario vendedor;

    @OneToMany (mappedBy = "venta")
    private List<DetalleVenta> detallesVenta;
}
