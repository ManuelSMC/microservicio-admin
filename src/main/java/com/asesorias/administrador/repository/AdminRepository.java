package com.asesorias.administrador.repository;

import com.asesorias.administrador.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Usuario, Integer> {
}