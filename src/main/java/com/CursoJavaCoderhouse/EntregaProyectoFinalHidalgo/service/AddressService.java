package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.service;


import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository; // Inyección de dependencia
}