package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.repository;

import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, UUID> { // Conexión con la base de datos para la entidad Vendor
}
