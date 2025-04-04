package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "DTO para crear una sucursal")
public class BranchCreateDTO {
    @Schema(description = "ID de la sucursal", example = "956101")
    private int sapId;
    @Schema(description = "Nombre de la sucursal", example = "Sucursal Centro")
    private String name;
    @Schema(description = "Indica si la sucursal es la central", example = "Predeterminada")
    private boolean isDefault;
    @Schema(description = "Tipo de documento", example = "CUIT")
    private String docType;
    @Schema(description = "Número de documento", example = "20-12345678-9")
    private String docId;
    @Schema(description = "Define si la sucursal es la central", example = "true")
    public boolean isDefault() {
        return isDefault;
    }
}
