package com.asesorias.administrador.service;

import com.asesorias.administrador.entity.Profesor;
import com.asesorias.administrador.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorServiceImpl implements ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    @Override
    public List<Profesor> getAll() {
        return profesorRepository.findAll();
    }

    @Override
    public Profesor getById(Integer id) {
        return profesorRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Profesor no encontrado con ID: " + id));
    }

    @Override
    public Profesor getByMatricula(String matricula) {
        return profesorRepository.findByMatricula(matricula)
            .orElseThrow(() -> new RuntimeException("Profesor no encontrado con matrícula: " + matricula));
    }
}