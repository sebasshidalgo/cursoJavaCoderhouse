package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto;

import lombok.*;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VendorResponseDTO {
    private UUID id;
    private String brandName;
    private String companyName;
    private String docType;
    private String docId;
    private String email;
    private AddressResponseDTO address;
    private List<BranchResponseDTO> branches;
    private List<CollaboratorsResponseDTO> collaborators;
}
