package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.startup;

import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class AppRunner implements CommandLineRunner { // Clase auxiliar que aplica el metodo run para carga inicial de datos y pruebas
    @Autowired
    private VendorService vendorService;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Probando App...");

        vendorService.printVendor();
    }
}


