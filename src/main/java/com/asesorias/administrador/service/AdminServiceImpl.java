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
    @Transactional
    public Usuario update(Integer id, UsuarioDTO usuarioDTO) {
        Optional<Usuario> usuarioOpt = adminRepository.findById(id);
        if (!usuarioOpt.isPresent()) {
            return null;
        }
        
        Usuario usuario = usuarioOpt.get();
        
        if (usuarioDTO.getNombre() != null) {
            usuario.setNombre(usuarioDTO.getNombre());
        }
        if (usuarioDTO.getPassword() != null) {
            usuario.setPassword(usuarioDTO.getPassword());
        }
        if (usuarioDTO.getRol() != null) {
            usuario.setRol(usuarioDTO.getRol());
        }
        if (usuarioDTO.getStatus() != null) {
            usuario.setStatus(usuarioDTO.getStatus());
        }
        
        if (usuarioDTO.getProgramasEducativosIds() != null) {
            usuario.getProgramasEducativos().clear();
            
            for (Integer programaId : usuarioDTO.getProgramasEducativosIds()) {
                UsuarioProgramaEducativo upe = new UsuarioProgramaEducativo();
                upe.setUsuario(usuario);
                upe.setProgramaEducativoId(programaId);
                usuario.getProgramasEducativos().add(upe);
            }
        }
        
        return adminRepository.save(usuario);
    }

    @Override
    @Transactional
    public Usuario disable(Integer id) {
        Optional<Usuario> usuarioOpt = adminRepository.findById(id);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            usuario.setStatus(0);  
            return adminRepository.save(usuario);
        }
        return null;
    }

    @Override
    @Transactional
    public Usuario enable(Integer id) {
        Optional<Usuario> usuarioOpt = adminRepository.findById(id);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            usuario.setStatus(1);  
            return adminRepository.save(usuario);
        }
        return null;  
    }
}