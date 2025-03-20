package com.CursoJavaCoderhouse.SegundaEntregaHidalgo.controller;

import com.CursoJavaCoderhouse.SegundaEntregaHidalgo.service.ColaboradoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/colaboradores")  // Ruta base para acceder a los endpoints
public class ColaboradoresController {

    @Autowired
    private ColaboradoresService colaboradoresService; // Inyección de dependencia

    @DeleteMapping // Metodo para eliminar todos los colaboradores
    public ResponseEntity<String> deleteAll() {
        colaboradoresService.deleteAll();
        return ResponseEntity.ok().body("Se eliminaron todos los colaboradores");
    }
}
