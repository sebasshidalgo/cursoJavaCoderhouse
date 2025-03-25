package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Table (name = "VENDOR")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vendor {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String brandName;
    private String companyName;
    private String docType;
    private String docId;
    private String email;
    // Relaciones
    @OneToOne(cascade = CascadeType.ALL) // Un vendor tiene un solo domicilio
    @JoinColumn(name = "address_id", referencedColumnName = "id") // Relaciona la tabla Vendor con la tabla Address
    private Address address;

    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL, orphanRemoval = true) // Un vendor tiene muchas branches
    private List<Branch> branches = new ArrayList<>();

    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY ) // Un vendor tiene muchos colaboradores
    private List<Collaborators> collaborators = new ArrayList<>();
}

