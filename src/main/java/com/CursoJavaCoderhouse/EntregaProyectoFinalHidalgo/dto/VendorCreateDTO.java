package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto;

import lombok.*;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VendorCreateDTO {
    private String brandName;
    private String companyName;
    private String docType;
    private String docId;
    private String email;
    private AddressCreateDTO address;
    private List<BranchCreateDTO> branches;
}
