package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.service;

import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto.VendorCreateDTO;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto.VendorResponseDTO;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto.VendorUpdateDTO;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.mapper.VendorMapper;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.model.Branch;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.model.Vendor;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.repository.BranchRepository;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.repository.VendorRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.h2.H2ConsoleAutoConfiguration;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class VendorService {
    private static final Logger logger = LoggerFactory.getLogger(VendorService.class); // Logger para registrar información

    @Autowired
    private VendorRepository vendorRepository; // Inyección de dependencia
    @Autowired
    private VendorMapper vendorMapper; // Inyección de dependencia

    @Transactional
    public VendorResponseDTO createVendor(VendorCreateDTO v) {  // Creación de proveedor
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

        // Log de información
        logger.info("✅ Se ha creado el proveedor: {} con ID: {}", savedVendor.getBrandName(), savedVendor.getId());

        // Convertir la entidad a DTO y devolverla
        return vendorMapper.toResponseDTO(savedVendor);
    }

    public List<VendorResponseDTO> getAllVendors() { // Obtener listado de proveedores
        // Obtener todos los proveedores de la base de datos y convertirlos a DTO
        List<Vendor> vendors = vendorRepository.findAll();
        if (vendors.isEmpty()) {
            logger.warn("⚠️ No se encontraron proveedores en la base de datos."); // Log de advertencia
        } else {
            logger.info("✅ Se han encontrado {} proveedores en la base de datos.", vendors.size()); // Log de información
        }

        // Convertir la lista de entidades a una lista de DTOs
        return vendors.stream()
                .map(vendorMapper::toResponseDTO)
                .toList();
    }

    public VendorResponseDTO getVendorById(UUID id) { // Obtener proveedor por ID
        Vendor vendor = vendorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("⚠️ El proveedor con ID " + id + " no existe.")); // Lanzar excepción si no existe el proveedor

        logger.info("✅ Se ha encontrado el proveedor con ID {}: {}", id, vendor.getBrandName()); // Log de información

        return vendorMapper.toResponseDTO(vendor); // Convertir la entidad a DTO y devolverla
    }

    @Transactional
    public VendorResponseDTO updateVendor(UUID id, VendorUpdateDTO updateDTO) { // Actualizar proveedor por ID
        Vendor vendor = vendorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("⚠️ El proveedor con ID " + id + " no existe."));

        // Actualizar solo los campos permitidos
        if (updateDTO.getBrandName() != null) {
            vendor.setBrandName(updateDTO.getBrandName());
        }
        if (updateDTO.getCompanyName() != null) {
            vendor.setCompanyName(updateDTO.getCompanyName());
        }
        if (updateDTO.getDocType() != null) {
            vendor.setDocType(updateDTO.getDocType());
        }
        if (updateDTO.getDocId() != null) {
            vendor.setDocId(updateDTO.getDocId());
        }
        if (updateDTO.getEmail() != null) {
            vendor.setEmail(updateDTO.getEmail());
        }

        // Guardar cambios en la base de datos
        Vendor updatedVendor = vendorRepository.save(vendor);

        logger.info("✅ Proveedor con ID {} actualizado correctamente.", id); // Log de información
        return vendorMapper.toResponseDTO(updatedVendor);
    }

    @Transactional
    public String deleteAllVendors() { // Eliminar todos los proveedores
        // Eliminar todos los proveedores de la base de datos
        long count = vendorRepository.count();

        if (count == 0) { // Verificar si hay proveedores para eliminar
            logger.warn("⚠️ No hay proveedores para eliminar."); // Log de advertencia
            return "No hay proveedores para eliminar.";
        }

        vendorRepository.deleteAll();
        logger.info("✅ Se han eliminado {} proveedores de la base de datos.", count); // Log de información

        return "Se eliminaron los proveedores correctamente.";
    }

    @Transactional
    public void deleteVendorById(UUID id) { // Eliminar un proveedor por su ID
        if (!vendorRepository.existsById(id)) {
            throw new EntityNotFoundException("⚠️ El proveedor con ID " + id + " no existe."); // Lanzar excepción si no existe el proveedor
        }
        vendorRepository.deleteById(id);
        logger.info("✅ Proveedor con ID {} eliminado correctamente", id); // Log de información
    }
}







