package com.asesorias.administrador.controller;

import com.asesorias.administrador.entity.Profesor;
import com.asesorias.administrador.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesores")
@CrossOrigin(origins = "*")
public class ProfesorController {
    
    @Autowired
    private ProfesorService profesorService;
    
    // VISUALIZAR TODOS
    @GetMapping("/visualizar")
    public ResponseEntity<List<Profesor>> visualizarTodos() {
        List<Profesor> profesores = profesorService.getAll();
        return ResponseEntity.ok(profesores);
    }
    
    // VISUALIZAR POR ID
    @GetMapping("/visualizar/{id}")
    public ResponseEntity<Profesor> visualizarPorId(@PathVariable Integer id) {
        try {
            Profesor profesor = profesorService.getById(id);
            return ResponseEntity.ok(profesor);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    
    // VISUALIZAR POR MATRÍCULA
    @GetMapping("/visualizar/matricula/{matricula}")
    public ResponseEntity<Profesor> visualizarPorMatricula(@PathVariable String matricula) {
        try {
            Profesor profesor = profesorService.getByMatricula(matricula);
            return ResponseEntity.ok(profesor);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}