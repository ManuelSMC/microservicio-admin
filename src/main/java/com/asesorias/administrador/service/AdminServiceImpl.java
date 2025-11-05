package com.asesorias.administrador.service;

import com.asesorias.administrador.entity.Usuario;
import com.asesorias.administrador.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    
    @Autowired
    private AdminRepository adminRepository;
    
    @Override
    public Usuario visualizarPorId(Long id) {
        return adminRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Administrador no encontrado con ID: " + id));
    }
    
    @Override
    public List<Usuario> visualizarTodos() {
        return adminRepository.findAll();
    }

    @Override
    public Usuario crear(Usuario usuario) {
        throw new UnsupportedOperationException("Unimplemented method 'crear'");
    }

    @Override
    public Usuario actualizar(Long id, Usuario usuario) {
        throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }

    @Override
    public void eliminar(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }
    
    // Implementa los otros métodos...
}