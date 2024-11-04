package com.gavi.server.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nombre;

    private String documento;

    @Column(nullable = false, unique = true)
    private String email;

    private String password;

}
