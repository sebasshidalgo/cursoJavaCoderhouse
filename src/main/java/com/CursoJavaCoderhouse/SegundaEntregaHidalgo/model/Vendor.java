package com.CursoJavaCoderhouse.SegundaEntregaHidalgo.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table (name = "VENDOR")
public class Vendor {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nombreFantasia;
    private String razonSocial;
    private String documentId;
    private String email;
    @OneToOne(cascade = CascadeType.ALL) // Un vendor tiene un solo domicilio
    @JoinColumn(name = "domicilio_id", referencedColumnName = "id")
    private Domicilio domicilio;
    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY ) // Un vendor tiene muchos colaboradores
    private List<Colaboradores> colaboradores = new ArrayList<>();


    // Constructor
    public Vendor(UUID id, String nombreFantasia, String razonSocial, String documentId, String email, Domicilio domicilio, List<Colaboradores> colaboradores) {
        this.id = id;
        this.nombreFantasia = nombreFantasia;
        this.razonSocial = razonSocial;
        this.documentId = documentId;
        this.email = email;
        this.domicilio = domicilio;
        this.colaboradores = (colaboradores != null) ? colaboradores : new ArrayList<>();
    }

    // Constructor por defecto
    public Vendor() {}

    // Getters & Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombreFantasia() {
        return nombreFantasia;
    }

    public void setNombreFantasia(String nombreFantasia) {
        this.nombreFantasia = nombreFantasia;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public List<Colaboradores> getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(List<Colaboradores> colaboradores) {
        this.colaboradores = (colaboradores != null) ? colaboradores : new ArrayList<>();
    }

    public boolean isPresent() {
        return false;
    }

    // toString
    @Override
    public String toString() {
        return "Vendor{" +
                "id=" + id +
                ", nombreFantasia='" + nombreFantasia + '\'' +
                ", razonSocial='" + razonSocial + '\'' +
                ", documentId='" + documentId + '\'' +
                ", email='" + email + '\'' +
                ", domicilio=" + (domicilio != null ? domicilio.getCalle() + " " + domicilio.getNumero() : "null") +
                ", colaboradores=" + (colaboradores != null ? colaboradores.size() : 0) +
                '}';
    }


}

