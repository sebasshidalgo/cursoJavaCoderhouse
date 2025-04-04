package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "DTO para crear un nuevo proveedor")
public class VendorCreateDTO {
    @NotNull(message = "Brand name cannot be null")
    @Size(min = 1, max = 100, message = "Brand name should be between 1 and 100 characters")
    @Schema(description = "Nombre de la marca del proveedor", example = "Coca Cola")
    private String brandName;
    @NotNull(message = "Company name cannot be null")
    @Schema(description = "Nombre de la empresa del proveedor", example = "Coca Cola Company SRL")
    private String companyName;
    @NotNull(message = "Document type cannot be null")
    @Schema(description = "Tipo de documento del proveedor", example = "CUIT")
    private String docType;
    @NotNull(message = "Document ID cannot be null")
    @Schema(description = "Número de documento del proveedor", example = "20-12345678-9")
    private String docId;
    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    @Schema(description = "Correo electrónico del proveedor", example = "contacto@coca-cola.com")
    private String email;
    @Valid // Validación de la dirección
    @Schema(description = "Dirección del proveedor")
    private AddressCreateDTO address;
    @Schema(description = "Lista de sucursales del proveedor")
    private List<BranchCreateDTO> branches;
}
