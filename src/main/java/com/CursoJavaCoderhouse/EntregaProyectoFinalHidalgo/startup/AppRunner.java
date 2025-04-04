package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.startup;

import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class AppRunner implements CommandLineRunner { // Clase auxiliar que aplica el metodo run para carga inicial de datos y pruebas
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Bienvenidos al ABM de Proveedores! 👋🏻" + "\n" +
                "Para comenzar, por favor ingrese vía Postman los datos del proveedor, sucursal, domicilio y/o colaborador que desea registrar o consultar..." + "\n" + "\n" +
                "Para más información, consulte la documentación de la API en el siguiente enlace: http://localhost:8080/swagger-ui/index.html#/" + "\n");
    }
}


