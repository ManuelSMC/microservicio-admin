package com.asesorias.administrador.service;

import com.asesorias.administrador.entity.Usuario;
import java.util.List;

public interface AdminService {
    
    // Método para visualizar UN administrador por ID
    Usuario visualizarPorId(Long id);
    
    // Método para visualizar TODOS los administradores
    List<Usuario> visualizarTodos();
    
    // Otros métodos que ya tengas...
    Usuario crear(Usuario usuario);
    Usuario actualizar(Long id, Usuario usuario);
    void eliminar(Long id);
}