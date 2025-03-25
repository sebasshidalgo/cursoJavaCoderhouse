package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.service;

import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.model.Vendor;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VendorService {

    @Autowired
    private VendorRepository vendorRepository; // Inyección de dependencia

    Vendor vendor = Vendor.builder()
            .brandName("Hidalgo")
            .companyName("Hidalgo S.A.")
            .docId("12345678")
            .email("mail@mail.com")
            .build();

    public Vendor saveVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    public void printVendor() {
        System.out.println(vendor);
        System.out.println(vendor.getEmail());
        vendor.setBrandName("Nuevo nombre fantasía");
        System.out.println(vendor.getBrandName());

    }
}




