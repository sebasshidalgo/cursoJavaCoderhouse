package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressResponseDTO {
    private Long id;
    private String street;
    private int number;
    private String apartment;
    private String city;
    private String state;
    private String country;
    private int zipCode;
}
