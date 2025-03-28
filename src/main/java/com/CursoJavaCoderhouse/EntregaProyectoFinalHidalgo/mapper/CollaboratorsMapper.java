package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.mapper;

import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto.CollaboratorsCreateDTO;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto.CollaboratorsResponseDTO;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.model.Collaborators;
import org.springframework.stereotype.Component;

@Component
public class CollaboratorsMapper {
    // Convertir de DTO a entidad
    public static Collaborators toEntity(CollaboratorsCreateDTO dto) {
        return Collaborators.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .docType(dto.getDocType())
                .docId(dto.getDocId())
                .build();
    }
    // Convertir de entidad a DTO
    public static CollaboratorsResponseDTO toResponseDTO(Collaborators collaborator) {
        if (collaborator == null) {
            return null;
        }
        return CollaboratorsResponseDTO.builder()
                .id(collaborator.getId())
                .firstName(collaborator.getFirstName())
                .lastName(collaborator.getLastName())
                .email(collaborator.getEmail())
                .docType(collaborator.getDocType())
                .docId(collaborator.getDocId())
                .build();
    }
}
