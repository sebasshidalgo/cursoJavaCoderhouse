package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto;

import lombok.*;
import java.util.UUID;

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
    private UUID vendorId;
}
