package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name = "ADDRESS")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private int number;
    private String apartment;
    private String city;
    private String state;
    private String country;
    private int zipCode;
    // Relaciones
    @OneToOne(mappedBy = "address") // Un vendor tiene un solo domicilio
    @JsonIgnore // Para evitar loop infinito
    private Vendor vendor;
}
