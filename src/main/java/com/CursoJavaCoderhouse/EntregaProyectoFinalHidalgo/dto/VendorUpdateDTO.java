package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VendorUpdateDTO {
    @Size(min = 1, max = 100, message = "Brand name should be between 1 and 100 characters")
    private String brandName;

    private String companyName;
    private String docType;
    private String docId;

    @Email(message = "Email should be valid")
    private String email;
}

