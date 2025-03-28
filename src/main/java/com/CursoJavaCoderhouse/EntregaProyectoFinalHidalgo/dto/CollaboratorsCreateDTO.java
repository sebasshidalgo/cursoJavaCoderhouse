package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CollaboratorsCreateDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String docType;
    private String docId;
}
