package com.CursoJavaCoderhouse.SegundaEntregaHidalgo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "COLABORADORES")
public class Colaboradores {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private int dni;
    @ManyToOne // Uno o varios colaboradores pertenecen a un solo vendor
    @JoinColumn(name = "vendor_id", nullable = false)
    @JsonIgnore // Para evitar loop infinito
    private Vendor vendor;

    // Constructor
    public Colaboradores(Long id, String nombre, String apellido, String email, int dni, Vendor vendor) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.dni = dni;
        this.vendor = vendor;
    }

    // Constructor por defecto
    public Colaboradores() {}

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
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
        return "Colaboradores{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", dni=" + dni +
                ", vendor=" + vendor +
                '}';
    }
}
