package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.mapper;

import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto.AddressResponseDTO;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto.VendorCreateDTO;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto.VendorResponseDTO;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.model.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public class VendorMapper {
    @Autowired
    private BranchMapper branchMapper;  // Inyección de dependencia
    @Autowired
    private CollaboratorsMapper collaboratorsMapper; // Inyección de dependencia

    // Convertir de DTO a entidad
    public Vendor toEntity(VendorCreateDTO dto) {
        return Vendor.builder()
                .brandName(dto.getBrandName())
                .companyName(dto.getCompanyName())
                .docType(dto.getDocType())
                .docId(dto.getDocId())
                .email(dto.getEmail())
                .address(dto.getAddress() != null ? AddressMapper.toEntity(dto.getAddress()) : null)  // Convierte Address si no es null
                .branches(dto.getBranches().stream().map(branchMapper::toEntity).toList()) // Convierte Branches a entidades
                .build();
    }

    // Convertir de entidad a DTO
    public VendorResponseDTO toResponseDTO(Vendor vendor) {
        VendorResponseDTO.VendorResponseDTOBuilder responseBuilder = VendorResponseDTO.builder()
                .id(vendor.getId())
                .brandName(vendor.getBrandName())
                .companyName(vendor.getCompanyName())
                .docType(vendor.getDocType())
                .docId(vendor.getDocId())
                .email(vendor.getEmail());

        responseBuilder.address(vendor.getAddress() != null ? AddressMapper.toResponseDTO(vendor.getAddress()) : null); // Convierte Address si no es null

        responseBuilder.branches(vendor.getBranches() != null && !vendor.getBranches().isEmpty()
                ? vendor.getBranches().stream().map(branchMapper::toResponseDTO).collect(Collectors.toList()) // Convierte Branches a DTOs
                : new ArrayList<>()); // Lista vacía si es null

        responseBuilder.collaborators(vendor.getCollaborators() != null && !vendor.getCollaborators().isEmpty()
                ? vendor.getCollaborators().stream().map(collaboratorsMapper::toResponseDTO).collect(Collectors.toList())
                : new ArrayList<>()); // Lista vacía si es null

        return responseBuilder.build();
    }
}

