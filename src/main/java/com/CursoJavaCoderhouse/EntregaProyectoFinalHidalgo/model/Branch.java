package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Table(name = "BRANCHES")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Branch {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private int sapId;
    private String name;
    private boolean isDefault;
    private String docType;
    private String docId;
    // Relaciones
    @ManyToOne // 1 o muchas branches pertenecen a un solo vendor
    @JoinColumn(name = "vendor_id", nullable = false)   // Relaciona la tabla Branch con la tabla Vendor
    private Vendor vendor;

    @ManyToMany // Muchos colaboradores pueden acceder a muchas branches
    @JoinTable(
            name = "collaborator_branch",
            joinColumns = @JoinColumn(name = "branch_id"),
            inverseJoinColumns = @JoinColumn(name = "collaborator_id") // Relaciona la tabla Branch con la tabla Collaborators
    )
    private List<Collaborators> collaborators = new ArrayList<>();
}
