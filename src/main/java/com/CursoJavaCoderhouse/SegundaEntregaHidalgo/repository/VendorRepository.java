package com.CursoJavaCoderhouse.SegundaEntregaHidalgo.repository;

import com.CursoJavaCoderhouse.SegundaEntregaHidalgo.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, UUID> {
    Optional<Vendor> findByDocumentId(String documentId);
}
