package com.CursoJavaCoderhouse.SegundaEntregaHidalgo.repository;

import com.CursoJavaCoderhouse.SegundaEntregaHidalgo.model.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface DomicilioRepository extends JpaRepository<Domicilio, Long> {
    Optional<Domicilio> findByCalleAndNumeroAndPisoDepto(String calle, int numero, String pisoDepto);
}
