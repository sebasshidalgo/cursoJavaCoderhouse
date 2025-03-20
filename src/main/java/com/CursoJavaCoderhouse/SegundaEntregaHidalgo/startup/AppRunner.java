package com.CursoJavaCoderhouse.SegundaEntregaHidalgo.startup;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class AppRunner implements CommandLineRunner { // Clase aux que aplica el metodo run para probar datos
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Realice sus peticiones a través de Postman...Muchas gracias");
    }
}


