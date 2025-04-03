package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.repository;

import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.model.Collaborators;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface CollaboratorsRepository extends JpaRepository<Collaborators, Long> { // Conexión con la base de datos para la entidad Collaborators
    boolean existsByEmail(String email); // Metodo para verificar existencia por email
}