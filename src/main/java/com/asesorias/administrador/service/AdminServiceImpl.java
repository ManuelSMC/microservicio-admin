package com.asesorias.administrador.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asesorias.administrador.dto.UsuarioDTO;
import com.asesorias.administrador.entity.Usuario;
import com.asesorias.administrador.entity.UsuarioProgramaEducativo;
import com.asesorias.administrador.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public List<Usuario> getAll() {
        // Obtener todos los usuarios (administradores)
        return adminRepository.findAll();
    }

    @Override
    public Usuario getById(Integer id) {
        // Visualizar un usuario por ID
        return adminRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Administrador no encontrado con ID: " + id));
    }

    @Override
    public Usuario create(Usuario usuario) {
        // Crear un nuevo usuario
        return null;
    }

    @Override
    public Usuario update(Integer id, UsuarioDTO adminDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Usuario disable(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'disable'");
    }

    @Override
    public Usuario enable(Integer id) {

        throw new UnsupportedOperationException("Unimplemented method 'enable'");
    }

      
    
}