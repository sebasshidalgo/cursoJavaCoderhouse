package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.mapper;

import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto.BranchCreateDTO;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto.BranchResponseDTO;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.model.Branch;
import org.springframework.stereotype.Component;

@Component
public class BranchMapper {
    // Convertir de DTO a entidad
    public Branch toEntity(BranchCreateDTO dto) {
        return Branch.builder()
                .sapId(dto.getSapId())
                .name(dto.getName())
                .isDefault(dto.isDefault())
                .docType(dto.getDocType())
                .docId(dto.getDocId())
                .build();
    }
    // Convertir de entidad a DTO
    public BranchResponseDTO toResponseDTO(Branch branch) {
        if (branch == null) {
            return null;
        }
        return BranchResponseDTO.builder()
                .sapId(branch.getSapId())
                .name(branch.getName())
                .isDefault(branch.isDefault())
                .vendorBrandName(branch.getVendor() != null ? branch.getVendor().getBrandName() : null)
                .build();
    }
}

