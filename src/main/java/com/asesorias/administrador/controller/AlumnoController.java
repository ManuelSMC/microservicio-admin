package com.asesorias.administrador.controller;

import com.asesorias.administrador.entity.Alumno;
import com.asesorias.administrador.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
@CrossOrigin(origins = "*")
public class AlumnoController {
    
    @Autowired
    private AlumnoService alumnoService;
    
    // VISUALIZAR TODOS
    @GetMapping("/visualizar")
    public ResponseEntity<List<Alumno>> visualizarTodos() {
        List<Alumno> alumnos = alumnoService.getAll();
        return ResponseEntity.ok(alumnos);
    }

    // VISUALIZAR POR MATRÍCULA
    @GetMapping("/visualizar/matricula/{matricula}")
    public ResponseEntity<Alumno> visualizarPorMatricula(@PathVariable String matricula) {
        try {
            Alumno alumno = alumnoService.getByMatricula(matricula);
            return ResponseEntity.ok(alumno);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}