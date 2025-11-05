package com.asesorias.administrador.service;

import com.asesorias.administrador.entity.Usuario;
import com.asesorias.administrador.dto.UsuarioDTO;
import java.util.List;

public interface AdminService {
    // CREATE
    Usuario create(Usuario usuario);

    // READ
    List<Usuario> getAll();

    Usuario getById(Integer id);

    // UPDATE
    Usuario update(Integer id, UsuarioDTO adminDTO);

    // DISABLE / ENABLE
    Usuario disable(Integer id);

    Usuario enable(Integer id);

    // AGREGA USUARIO
    Usuario agregarUsuario(UsuarioDTO usuarioDTO);

}
