package com.asesorias.administrador.controller;

import com.asesorias.administrador.entity.Usuario;
import com.asesorias.administrador.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/administradores")
@CrossOrigin(origins = "*") // Ajusta según tu configuración de CORS
public class AdminController {
    
    @Autowired
    private AdminService adminService;
    
    // Endpoint para visualizar UN administrador
    @GetMapping("/visualizar/{id}")
    public ResponseEntity<Usuario> visualizarAdministrador(@PathVariable Long id) {
        try {
            Usuario admin = adminService.visualizarPorId(id);
            return ResponseEntity.ok(admin);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    
    // Endpoint para visualizar TODOS los administradores
    @GetMapping("/visualizar")
    public ResponseEntity<List<Usuario>> visualizarTodos() {
        List<Usuario> administradores = adminService.visualizarTodos();
        return ResponseEntity.ok(administradores);
    }
    
    // Otros endpoints (crear, actualizar, eliminar)...
}