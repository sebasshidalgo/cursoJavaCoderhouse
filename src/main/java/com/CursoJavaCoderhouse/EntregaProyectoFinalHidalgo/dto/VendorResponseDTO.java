package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "DTO para la respuesta de un proveedor")
public class VendorResponseDTO {
    @Schema(description = "ID del proveedor", example = "123e4567-e89b-12d3-a456-426614174000")
    private UUID id;
    @Schema(description = "Nombre de la marca", example = "Coca-Cola")
    private String brandName;
    @Schema(description = "Nombre de la empresa", example = "Coca-Cola Company SRL")
    private String companyName;
    @Schema(description = "Tipo de documento", example = "CUIT")
    private String docType;
    @Schema(description = "Número de documento", example = "20-12345678-9")
    private String docId;
    @Schema(description = "Correo electrónico del proveedor", example = "contacto@coca-cola.com")
    private String email;
    @Schema(description = "Dirección del proveedor")
    private AddressResponseDTO address;
    @Schema(description = "Lista de sucursales del proveedor")
    private List<BranchResponseDTO> branches;
    @Schema(description = "Lista de colaboradores del proveedor")
    private List<CollaboratorsResponseDTO> collaborators;
}
