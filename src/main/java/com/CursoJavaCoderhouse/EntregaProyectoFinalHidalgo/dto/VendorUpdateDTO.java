package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "DTO para actualizar un proveedor")
public class VendorUpdateDTO {
    @Size(min = 1, max = 100, message = "Brand name should be between 1 and 100 characters")
    @Schema(description = "Nombre de la marca del proveedor", example = "Coca Cola")
    private String brandName;
    @Schema(description = "Nombre de la empresa del proveedor", example = "Coca Cola Company SRL")
    private String companyName;
    @Schema(description = "Tipo de documento del proveedor", example = "CUIT")
    private String docType;
    @Schema(description = "Número de documento del proveedor", example = "20-12345678-9")
    private String docId;
    @Email(message = "Email should be valid")
    @Schema(description = "Correo electrónico del proveedor", example = "contacto@coca-cola.com")
    private String email;
}

