package com.asesorias.administrador.service;

import com.asesorias.administrador.entity.Alumno;
import com.asesorias.administrador.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    public List<Alumno> getAll() {
        return alumnoRepository.findAll();
    }

    @Override
    public Alumno getById(Integer id) {
        return alumnoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Alumno no encontrado con ID: " + id));
    }

    @Override
    public Alumno getByMatricula(String matricula) {
        return alumnoRepository.findByMatricula(matricula)
            .orElseThrow(() -> new RuntimeException("Alumno no encontrado con matrícula: " + matricula));
    }
}