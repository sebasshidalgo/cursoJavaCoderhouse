package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "DTO para la respuesta de una dirección")
public class AddressResponseDTO {
    @Schema(description = "ID de la dirección", example = "1")
    private Long id;
    @Schema(description = "Nombre de la calle", example = "Calle Falsa")
    private String street;
    @Schema(description = "Número de la calle", example = "123")
    private int number;
    @Schema(description = "Número de departamento", example = "8° A")
    private String apartment;
    @Schema(description = "Nombre de la ciudad", example = "CABA")
    private String city;
    @Schema(description = "Nombre de la provincia", example = "Buenos Aires")
    private String state;
    @Schema(description = "Nombre del país", example = "Argentina")
    private String country;
    @Schema(description = "Código postal", example = "1540")
    private int zipCode;
}
