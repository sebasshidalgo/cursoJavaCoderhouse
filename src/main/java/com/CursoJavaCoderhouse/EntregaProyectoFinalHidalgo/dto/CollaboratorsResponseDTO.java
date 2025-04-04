package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "DTO para la respuesta de los colaboradores")
public class CollaboratorsResponseDTO {
    @Schema(description = "ID del colaborador", example = "1")
    private Long id;
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
}
