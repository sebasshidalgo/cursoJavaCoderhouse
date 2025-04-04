package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.service;

import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.repository.CollaboratorsRepository;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.repository.VendorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto.CollaboratorsCreateDTO;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto.CollaboratorsResponseDTO;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.mapper.CollaboratorsMapper;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.model.Collaborators;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.model.Vendor;


@Service
public class CollaboratorsService {
    private static final Logger logger = LoggerFactory.getLogger(CollaboratorsService.class);

    @Autowired
    private CollaboratorsRepository collaboratorsRepository; // Inyección de dependencias
    @Autowired
    private VendorRepository vendorRepository;
    @Autowired
    private CollaboratorsMapper collaboratorsMapper;

    // Crear un nuevo colaborador
    @Transactional
    public CollaboratorsResponseDTO createCollaborator(CollaboratorsCreateDTO collaboratorDTO, UUID vendorId) {
        // Verificar si el proveedor existe
        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new EntityNotFoundException("⚠️ El proveedor con ID " + vendorId + " no existe."));
        // Verificar si el colaborador ya existe
        if (collaboratorsRepository.existsByEmail(collaboratorDTO.getEmail())) {
            throw new EntityNotFoundException("⚠️ El colaborador con el email " + collaboratorDTO.getEmail() + " ya existe.");
        }
        // Convertir el DTO a entidad
        Collaborators collaborator = collaboratorsMapper.toEntity(collaboratorDTO);

        // Asociar el colaborador con el vendor
        collaborator.setVendor(vendor);

        // Guardar el colaborador en la base de datos
        Collaborators savedCollaborator = collaboratorsRepository.save(collaborator);
        logger.info("✅ Colaborador {} {} creado con ID: {} en proveedor {}", savedCollaborator.getFirstName(), savedCollaborator.getLastName(), savedCollaborator.getId(), vendor.getBrandName()); // Log de creación

        return collaboratorsMapper.toResponseDTO(savedCollaborator);
    }

    // Obtener todos los colaboradores
    public List<CollaboratorsResponseDTO> getAllCollaborators() {
        List<Collaborators> collaborators = collaboratorsRepository.findAll();
        if (collaborators.isEmpty()) {
            logger.warn("⚠️ No se encontraron colaboradores."); // Log de advertencia
        } else {
            logger.info("✅ Se encontraron {} colaboradores.", collaborators.size()); // Log de información
        }
        return collaborators.stream().map(collaboratorsMapper::toResponseDTO).toList();
    }

    // Obtener un colaborador por ID
    public CollaboratorsResponseDTO getCollaboratorById(Long id) {
        Collaborators collaborator = collaboratorsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("⚠️ El colaborador con ID " + id + " no existe."));

        logger.info("✅ Colaborador {} {} encontrado con ID: {}", collaborator.getFirstName(), collaborator.getLastName(), id); // Log de búsqueda
        return collaboratorsMapper.toResponseDTO(collaborator);
    }

    // Actualizar un colaborador por ID
    public CollaboratorsResponseDTO updateCollaborator(Long id, @Valid CollaboratorsCreateDTO collaboratorDTO) {
        Collaborators collaborator = collaboratorsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("⚠️ El colaborador con ID " + id + " no existe."));
        // Actualizar los campos del colaborador
        collaborator.setFirstName(collaboratorDTO.getFirstName());
        collaborator.setLastName(collaboratorDTO.getLastName());
        collaborator.setEmail(collaboratorDTO.getEmail());
        collaborator.setDocType(collaboratorDTO.getDocType());
        collaborator.setDocId(collaboratorDTO.getDocId());

        Collaborators updatedCollaborator = collaboratorsRepository.save(collaborator);
        logger.info("✅ Colaborador actualizado con ID: {}", updatedCollaborator.getId()); // Log de actualización
        return collaboratorsMapper.toResponseDTO(updatedCollaborator);
    }

    // Eliminar un colaborador por ID
    public void deleteCollaboratorById(Long id) {
        Collaborators collaborator = collaboratorsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("⚠️ El colaborador con ID " + id + " no existe."));
        collaboratorsRepository.delete(collaborator);
        logger.info("✅ Colaborador eliminado con ID: {}", id);
    }

    // Eliminar todos los colaboradores
    public void deleteAllCollaborators() {
        collaboratorsRepository.deleteAll();
        logger.info("✅ Todos los colaboradores han sido eliminados.");
    }
}
