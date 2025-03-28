package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto;

import jakarta.validation.Valid;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VendorCreateDTO {
    @NotNull(message = "Brand name cannot be null")
    @Size(min = 1, max = 100, message = "Brand name should be between 1 and 100 characters")
    private String brandName;

    @NotNull(message = "Company name cannot be null")
    private String companyName;

    @NotNull(message = "Document type cannot be null")
    private String docType;

    @NotNull(message = "Document ID cannot be null")
    private String docId;

    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    private String email;

    @Valid // Validación de la dirección
    private AddressCreateDTO address;

    private List<BranchCreateDTO> branches;
}
