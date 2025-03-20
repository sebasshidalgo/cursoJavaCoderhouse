package com.CursoJavaCoderhouse.SegundaEntregaHidalgo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table (name = "DOMICILIO")
public class Domicilio {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String calle;
    private int numero;
    private String pisoDepto;
    private String ciudad;
    private int codigoPostal;
    @OneToOne(mappedBy = "domicilio") // Un vendor tiene un solo domicilio
    @JsonIgnore // Para evitar loop infinito
    private Vendor vendor;

    // Constructor
    public Domicilio(Long id, String calle, int numero, String pisoDepto, String ciudad, int codigoPostal, Vendor vendor) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.pisoDepto = pisoDepto;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.vendor = vendor;
    }

    // Constructor por defecto
    public Domicilio() {}

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPisoDepto() {
        return pisoDepto;
    }

    public void setPisoDepto(String pisoDepto) {
        this.pisoDepto = pisoDepto;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    // toString
    @Override
    public String toString() {
        return "Domicilio{" +
                "id=" + id +
                ", calle='" + calle + '\'' +
                ", numero=" + numero +
                ", pisoDepto='" + pisoDepto + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", codigoPostal=" + codigoPostal +
                ", vendor=" + (vendor != null ? vendor.getNombreFantasia() : "null") +
                '}';
    }
}
