package com.asesorias.administrador.dto;

import java.util.List;

import lombok.Data;

@Data
public class UsuarioDTO {
    private String nombre;
    private String password;
    private String rol;
    private Integer status;
    private List<Integer> programasEducativosIds;
}