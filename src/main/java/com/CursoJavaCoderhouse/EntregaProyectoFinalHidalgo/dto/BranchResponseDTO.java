package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BranchResponseDTO {
    private int sapId;
    private String name;
    private boolean isDefault;
    private String vendorBrandName;
}
