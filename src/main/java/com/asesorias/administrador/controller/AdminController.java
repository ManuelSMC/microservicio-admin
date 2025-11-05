package com.asesorias.administrador.controller;

import java.util.List;
import com.asesorias.administrador.dto.UsuarioDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.asesorias.administrador.entity.Usuario;
import com.asesorias.administrador.service.AdminService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // CREATE
    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
        Usuario nuevo = adminService.create(usuario);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    // READ - Get all
    @GetMapping
    public ResponseEntity<List<Usuario>> getAll() {
        List<Usuario> lista = adminService.getAll();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    // READ - Get by ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable Integer id) {
        Usuario usuario = adminService.getById(id);
        if (usuario != null) {
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Integer id, @RequestBody UsuarioDTO usuarioDTO) {
        Usuario actualizado = adminService.update(id, usuarioDTO);
        if (actualizado != null) {
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DISABLE
    @PutMapping("/{id}/disable")
    public ResponseEntity<Usuario> disable(@PathVariable Integer id) {
        Usuario deshabilitado = adminService.disable(id);
        if (deshabilitado != null) {
            return new ResponseEntity<>(deshabilitado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // ENABLE
    @PutMapping("/{id}/enable")
    public ResponseEntity<Usuario> enable(@PathVariable Integer id) {
        Usuario habilitado = adminService.enable(id);
        if (habilitado != null) {
            return new ResponseEntity<>(habilitado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/agregarUsuario")
    public ResponseEntity<Usuario> agregarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario nuevoUsuario = adminService.agregarUsuario(usuarioDTO);
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    }

}
