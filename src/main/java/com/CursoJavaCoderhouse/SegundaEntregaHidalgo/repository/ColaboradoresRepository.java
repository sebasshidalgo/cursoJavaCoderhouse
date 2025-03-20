package com.CursoJavaCoderhouse.SegundaEntregaHidalgo.repository;

import com.CursoJavaCoderhouse.SegundaEntregaHidalgo.model.Colaboradores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColaboradoresRepository extends JpaRepository<Colaboradores, Long> {
}
