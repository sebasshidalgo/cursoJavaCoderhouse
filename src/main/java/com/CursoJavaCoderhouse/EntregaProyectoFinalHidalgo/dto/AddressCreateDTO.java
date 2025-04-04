package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "DTO para crear una nueva dirección")
public class AddressCreateDTO {
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
