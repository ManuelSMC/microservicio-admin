package com.asesorias.administrador.service;

import com.asesorias.administrador.entity.Alumno;
import java.util.List;

public interface AlumnoService {
    
    // Solo VISUALIZAR
    List<Alumno> getAll();
    Alumno getById(Integer id);
    Alumno getByMatricula(String matricula);
}