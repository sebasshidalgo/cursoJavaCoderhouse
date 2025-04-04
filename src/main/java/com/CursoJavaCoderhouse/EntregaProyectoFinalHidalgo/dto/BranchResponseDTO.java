package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "DTO para la respuesta de una sucursal")
public class BranchResponseDTO {
    @Schema(description = "ID de la sucursal", example = "956101")
    private int sapId;
    @Schema(description = "Nombre de la sucursal", example = "Sucursal Centro")
    private String name;
    @Schema(description = "Indica si la sucursal es la central", example = "Predeterminada")
    private boolean isDefault;
    @Schema(description = "Nombre de la marca del vendor asociado", example = "Coca-Cola")
    private String vendorBrandName;
}
