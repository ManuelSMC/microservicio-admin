package com.asesorias.administrador.entity;

import jakarta.persistence.*;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.asesorias.administrador.dto.ProgramaEducativoDTO;

import lombok.Data;

@Entity
@Table(name = "usuario")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "password")
    private String password;

    @Column(name = "rol")
    private String rol;

    @Column(name = "status")
    private int status;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "programa_educativo")
    @JsonManagedReference
    private List<ProgramaEducativoDTO> programasEducativos;
}
