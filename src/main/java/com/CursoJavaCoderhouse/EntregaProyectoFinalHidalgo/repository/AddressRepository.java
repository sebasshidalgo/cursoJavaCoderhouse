package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.repository;

import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface AddressRepository extends JpaRepository<Address, UUID> { // Conexión con la base de datos para la entidad Address
}