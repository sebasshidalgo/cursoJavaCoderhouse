package com.CursoJavaCoderhouse.SegundaEntregaHidalgo.service;

import com.CursoJavaCoderhouse.SegundaEntregaHidalgo.model.Domicilio;
import com.CursoJavaCoderhouse.SegundaEntregaHidalgo.model.Vendor;
import com.CursoJavaCoderhouse.SegundaEntregaHidalgo.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class VendorService {

    @Autowired
    private VendorRepository vendorRepository; // Inyección de dependencia
    @Autowired
    private DomicilioService domicilioService; // Inyección de DomicilioService para validación de datos


    public Vendor save(Vendor vendor) {
        // Verifica si ya existe un Vendor con el mismo documentId
        Optional<Vendor> existingVendor = vendorRepository.findByDocumentId(vendor.getDocumentId());

        if (existingVendor.isPresent()) {
            System.out.println("❌ Vendor con documentId " + vendor.getDocumentId() + " ya existe.");
            return existingVendor.get();
        }

        // Guarda el vendor
        Vendor savedVendor = vendorRepository.save(new Vendor(vendor.getId(), vendor.getNombreFantasia(), vendor.getRazonSocial(), vendor.getDocumentId(), vendor.getEmail(), null, null));

        // Si el vendor tiene domicilio, lo guarda después
        if (vendor.getDomicilio() != null) {
            Domicilio domicilio = vendor.getDomicilio();
            domicilio.setVendor(savedVendor); // Asocia el vendor ya persistido

            Domicilio savedDomicilio = domicilioService.save(domicilio);
            savedVendor.setDomicilio(savedDomicilio);
        }

        return vendorRepository.save(savedVendor); // Actualiza el Vendor con el domicilio
    }

    public List<Vendor> findAll() {
        return vendorRepository.findAll();
    }

    public Optional<Vendor> findById(UUID id) {
        return vendorRepository.findById(id);
    }

    public void delete(UUID id) {
        if (!vendorRepository.existsById(id)) {
            throw new IllegalArgumentException("❌ No se encontró el vendor con UUID " + id);
        }
        vendorRepository.deleteById(id);
    }

    public void deleteAll() {
        vendorRepository.deleteAll();
    }

    public Vendor getVendorWithColaboradores(UUID vendorId) {
        return vendorRepository.findById(vendorId)
                .orElseThrow(() -> new RuntimeException("Vendor no encontrado"));
    }

    public Vendor update(UUID id, Vendor vendor) {
        // Verifica si el vendor existe
        Vendor existingVendor = vendorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vendor no encontrado"));

        if (existingVendor.isPresent()) {
            System.out.println("❌ Vendor con Id " + vendor.getId() + " ya existe.");
            return existingVendor;
        }

        // Actualiza los datos del vendor
        existingVendor.setNombreFantasia(vendor.getNombreFantasia());
        existingVendor.setRazonSocial(vendor.getRazonSocial());
        existingVendor.setDocumentId(vendor.getDocumentId());
        existingVendor.setEmail(vendor.getEmail());

        // Guarda el vendor actualizado
        return vendorRepository.save(existingVendor);
    }
}


