package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.repository;

import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.model.Collaborators;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface CollaboratorsRepository extends JpaRepository<Collaborators, UUID> { // Conexión con la base de datos para la entidad Collaborators
}