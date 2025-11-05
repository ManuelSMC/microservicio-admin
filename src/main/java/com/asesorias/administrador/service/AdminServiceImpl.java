package com.asesorias.administrador.service;

import com.asesorias.administrador.client.ProgramaEducativoClient;
import com.asesorias.administrador.dto.UsuarioDTO;
import com.asesorias.administrador.dto.ProgramaEducativoDTO;
import com.asesorias.administrador.entity.Usuario;
import com.asesorias.administrador.entity.UsuarioProgramaEducativo;
import com.asesorias.administrador.repository.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired(required = false)
    private ProgramaEducativoClient programaEducativoClient;

    @Override
    public List<Usuario> getAll() {
        return adminRepository.findAll();
    }

    @Override
    public Usuario getById(Integer id) {
        Optional<Usuario> usuarioOpt = adminRepository.findById(id);
        return usuarioOpt.orElse(null);
    }

    @Override
    public Usuario create(Usuario usuario) {
        return adminRepository.save(usuario);
    }

    @Override
    public Usuario update(Integer id, UsuarioDTO usuarioDTO) {
        Optional<Usuario> optional = adminRepository.findById(id);
        if (optional.isPresent()) {
            Usuario usuario = optional.get();
            if (usuarioDTO.getNombre() != null)
                usuario.setNombre(usuarioDTO.getNombre());
            if (usuarioDTO.getPassword() != null)
                usuario.setPassword(usuarioDTO.getPassword());
            if (usuarioDTO.getRol() != null)
                usuario.setRol(usuarioDTO.getRol());
            if (usuarioDTO.getStatus() != null)
                usuario.setStatus(usuarioDTO.getStatus());
            return adminRepository.save(usuario);
        }
        return null;
    }

    @Override
    public Usuario disable(Integer id) {
        Optional<Usuario> optional = adminRepository.findById(id);
        if (optional.isPresent()) {
            Usuario usuario = optional.get();
            usuario.setStatus("INACTIVO");
            return adminRepository.save(usuario);
        }
        return null;
    }

    @Override
    public Usuario enable(Integer id) {
        Optional<Usuario> optional = adminRepository.findById(id);
        if (optional.isPresent()) {
            Usuario usuario = optional.get();
            usuario.setStatus("ACTIVO");
            return adminRepository.save(usuario);
        }
        return null;
    }

    // NUEVO MÉTODO: agregar usuario desde DTO
    @Override
    public Usuario agregarUsuario(UsuarioDTO usuarioDTO) {
        Usuario nuevo = new Usuario();
        nuevo.setNombre(usuarioDTO.getNombre());
        nuevo.setPassword(usuarioDTO.getPassword());
        nuevo.setRol(usuarioDTO.getRol());
        nuevo.setStatus(usuarioDTO.getStatus());

        if (usuarioDTO.getProgramasEducativos() != null && !usuarioDTO.getProgramasEducativos().isEmpty()) {
            List<ProgramaEducativoDTO> programas = usuarioDTO.getProgramasEducativos();

        }

        return adminRepository.save(nuevo);
    }
}
