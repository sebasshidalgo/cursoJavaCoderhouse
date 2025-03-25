/*package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.controller;

import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.model.Domicilio;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.service.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/domicilios")  // Ruta base para acceder a los endpoints
public class DomicilioController {

    @Autowired
    private DomicilioService domicilioService; // Inyección de dependencia

    @PostMapping // Metodo para crear un nuevo domicilio
    public ResponseEntity<Domicilio> newDomicilio(@RequestBody Domicilio d) {
        Domicilio newDomicilio = domicilioService.save(d);
        return ResponseEntity.ok().body(newDomicilio);
    }

    @DeleteMapping // Metodo para eliminar todos los domicilios
    public ResponseEntity<String> deleteAll() {
        domicilioService.deleteAll();
        return ResponseEntity.ok().body("Se eliminaron todos los domicilios");
    }

    @PutMapping("/{id}") // Metodo para actualizar un domicilio por su id
    public ResponseEntity<Domicilio> updateDomicilio(@PathVariable Long id, @RequestBody Domicilio domicilio) {
        Domicilio updatedDomicilio = domicilioService.update(id, domicilio);
        return ResponseEntity.ok().body(updatedDomicilio);
    }

    @GetMapping() // Metodo para obtener el listado de domicilios
    public ResponseEntity<List<Domicilio>> obtenerDomicilios() {
        List<Domicilio> domicilios = domicilioService.findAll();
        return ResponseEntity.ok().body(domicilios);
    }
}*/
