package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.service;

import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto.VendorCreateDTO;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto.VendorResponseDTO;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.mapper.VendorMapper;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.model.Branch;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.model.Vendor;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.repository.BranchRepository;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.repository.VendorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;


@Service
public class VendorService {
    @Autowired
    private VendorRepository vendorRepository; // Inyección de dependencia
    @Autowired
    private VendorMapper vendorMapper; // Inyección de dependencia
    @Autowired
    private BranchRepository branchRepository; // Inyección de dependencia

    @Transactional
    public VendorResponseDTO createVendor(VendorCreateDTO v) {
        // Convierte el DTO a entidad
        Vendor vendor = vendorMapper.toEntity(v);

        // Asociar las Branches al Vendor antes de persistirlas
        List<Branch> branches = vendor.getBranches();
        if (branches != null) {
            for (Branch branch : branches) {
                branch.setVendor(vendor);  // Asociar cada Branch con el Vendor
            }
        }

        // Persistir el Vendor y las Branches asociadas
        Vendor savedVendor = vendorRepository.save(vendor);

        // Convertir la entidad a DTO y devolverla
        return vendorMapper.toResponseDTO(savedVendor);
    }
}





