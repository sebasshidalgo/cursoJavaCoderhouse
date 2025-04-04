package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "DTO para la creación de colaboradores")
public class CollaboratorsCreateDTO {
    @Schema(description = "Nombre del colaborador", example = "Juan")
    private String firstName;
    @Schema(description = "Apellido del colaborador", example = "Pérez")
    private String lastName;
    @Schema(description = "Correo electrónico del colaborador", example = "juan.perez@mail.com")
    private String email;
    @Schema(description = "Tipo de documento del colaborador", example = "DNI")
    private String docType;
    @Schema(description = "Número de documento del colaborador", example = "12345678")
    private String docId;
    @Schema(description = "ID del vendedor al que pertenece el colaborador", example = "123e4567-e89b-12d3-a456-426614174000")
    private UUID vendorId;
}
