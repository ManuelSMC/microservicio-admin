package com.asesorias.administrador.service;

import com.asesorias.administrador.entity.Profesor;
import java.util.List;

public interface ProfesorService {
    
    // Solo VISUALIZAR
    List<Profesor> getAll();
    Profesor getById(Integer id);
    Profesor getByMatricula(String matricula);
}