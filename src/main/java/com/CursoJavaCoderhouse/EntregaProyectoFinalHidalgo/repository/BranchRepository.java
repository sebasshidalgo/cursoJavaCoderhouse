package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.repository;

import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface BranchRepository extends JpaRepository<Branch, UUID> { // Conexión con la base de datos para la entidad Branch
}
