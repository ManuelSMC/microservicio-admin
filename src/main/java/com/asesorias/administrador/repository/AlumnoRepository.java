package com.asesorias.administrador.repository;

import com.asesorias.administrador.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
    Optional<Alumno> findByMatricula(String matricula);
}