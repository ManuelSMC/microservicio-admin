package com.asesorias.administrador.dto;

import lombok.Data;
import java.util.List;

@Data
public class UsuarioDTO {
    private String nombre;
    private String password;
    private String rol;
    private String status;
    private List<ProgramaEducativoDTO> programasEducativos;
}
