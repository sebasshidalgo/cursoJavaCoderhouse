package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CollaboratorsResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String docType;
    private String docId;
}
