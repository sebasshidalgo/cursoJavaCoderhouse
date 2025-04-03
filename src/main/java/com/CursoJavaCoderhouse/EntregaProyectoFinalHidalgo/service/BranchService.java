package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.service;

import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto.BranchCreateDTO;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto.BranchResponseDTO;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.mapper.BranchMapper;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.model.Branch;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.model.Vendor;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.repository.BranchRepository;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.repository.VendorRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class BranchService {
    private static final Logger logger = LoggerFactory.getLogger(BranchService.class);

    @Autowired
    private BranchRepository branchRepository; // Inyección de dependencia
    @Autowired
    private VendorRepository vendorRepository; // Inyección de dependencia
    @Autowired
    private BranchMapper branchMapper; // Inyección de dependencia

    // Crear nueva branch
    @Transactional
    public BranchResponseDTO createBranch(BranchCreateDTO branchDTO, UUID vendorId) {
        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new EntityNotFoundException("⚠️ El proveedor con ID " + vendorId + " no existe."));

        Branch branch = branchMapper.toEntity(branchDTO); // Convierte el DTO a entidad
        branch.setVendor(vendor); // Asocia la branch al vendor

        Branch savedBranch = branchRepository.save(branch); // Guarda la branch en la base de datos
        logger.info("✅ Sucursal creada con ID: {}", savedBranch.getId()); // Log de información

        return branchMapper.toResponseDTO(savedBranch); // Convierte la entidad guardada a DTO y lo devuelve
    }

    // Consultar listado de branches
    public List<BranchResponseDTO> getAllBranches() {
        List<Branch> branches = branchRepository.findAll();
        if (branches.isEmpty()) {
            logger.warn("⚠️ No se encontraron sucursales."); // Log de advertencia
        } else {
            logger.info("✅ Se encontraron {} sucursales.", branches.size()); // Log de información
        }

        return branches.stream().map(branchMapper::toResponseDTO).toList(); // Convierte cada branch a DTO
    }

    // Consultar branch por id
    public BranchResponseDTO getBranchById(UUID id) {
        Branch branch = branchRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("⚠️ La sucursal con ID " + id + " no existe."));
        return branchMapper.toResponseDTO(branch); // Convierte la branch a DTO
    }

    // Actualizar branch por id
    @Transactional
    public BranchResponseDTO updateBranch(UUID id, BranchCreateDTO branchDTO) {
        Branch branch = branchRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("⚠️ La sucursal con ID " + id + " no existe."));

        // Actualizar solo los atributos permitidos
        branch.setSapId(branchDTO.getSapId());
        branch.setName(branchDTO.getName());
        branch.setDefault(branchDTO.isDefault());
        branch.setDocType(branchDTO.getDocType());
        branch.setDocId(branchDTO.getDocId());

        Branch updatedBranch = branchRepository.save(branch);
        logger.info("✅ Sucursal con ID {} actualizada correctamente.", id); // Log de información

        return branchMapper.toResponseDTO(updatedBranch); // Convierte la branch actualizada a DTO y lo devuelve
    }

    // Eliminar branch por id
    @Transactional
    public void deleteBranchById(UUID id) {
        if (!branchRepository.existsById(id)) {
            throw new EntityNotFoundException("⚠️ La sucursal con ID " + id + " no existe.");
        }
        branchRepository.deleteById(id);
        logger.info("✅ Sucursal con ID {} eliminada correctamente.", id); // Log de información
    }

    // Eliminar todas las branches
    @Transactional
    public void deleteAllBranches() {
        if (branchRepository.count() == 0) {
            throw new EntityNotFoundException("⚠️ No hay sucursales para eliminar.");
        }
        branchRepository.deleteAll();
        logger.info("✅ Todas las sucursales han sido eliminadas correctamente."); // Log de información
    }
}
