package com.asesorias.administrador.service;

import com.asesorias.administrador.client.ProgramaEducativoClient;
import com.asesorias.administrador.dto.UsuarioDTO;
import com.asesorias.administrador.dto.ProgramaEducativoDTO;
import com.asesorias.administrador.entity.Usuario;
import com.asesorias.administrador.entity.UsuarioProgramaEducativo;
import com.asesorias.administrador.repository.AdminRepository;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ProgramaEducativoClient programaEducativoClient;

    @Override
    public List<Usuario> getAll() {
        // Implementar lógica para obtener todos los usuarios
        return new ArrayList<>();
    }

    @Override
    public Usuario getById(Integer id) {
        // Obtener un usuario por ID
        return null;
    }

    @Override
    public Usuario create(Usuario usuario) {
        // Crear un nuevo usuario
        return null;
    }

    @Override
    public Usuario update(Integer id, UsuarioDTO usuarioDTO) {
        // Actualizar un usuario
        return null;
    }

    @Override
    public Usuario disable(Integer id) {
        // Deshabilitar un usuario
        Optional<Usuario> usuarioOpt = adminRepository.findById(id);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            usuario.setStatus(0);  
            return adminRepository.save(usuario);
        }
        return null;
    }

    @Override
    public Usuario enable(Integer id) {
        // Habilitar un usuario
        Optional<Usuario> usuarioOpt = adminRepository.findById(id);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            usuario.setStatus(1);  
            return adminRepository.save(usuario);
        }
        return null;  
    }
}