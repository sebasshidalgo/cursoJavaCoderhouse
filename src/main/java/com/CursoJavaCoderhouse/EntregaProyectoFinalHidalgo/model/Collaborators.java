package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Table(name = "COLLABORATORS")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Collaborators {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String docType;
    private String docId;
    // Relaciones
    @ManyToOne // Uno o varios colaboradores pertenecen a un solo vendor
    @JoinColumn(name = "vendor_id", nullable = true) // Relaciona la tabla Collaborators con la tabla Vendor
    @JsonIgnore // Para evitar loop infinito
    private Vendor vendor;

    @ManyToMany(mappedBy = "collaborators") // Muchos colaboradores pueden acceder a muchas branches
    private List<Branch> branches = new ArrayList<>();
}
