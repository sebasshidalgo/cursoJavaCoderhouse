/*
package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.controller;


import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.model.Vendor;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/vendors")  // Ruta base para acceder a los endpoints
public class VendorController {
    @Autowired
    private VendorService vendorService; // Inyección de dependencia

    @PostMapping // Metodo para crear un nuevo vendor
    public ResponseEntity<Vendor> newVendor(@RequestBody Vendor v) {
        Vendor newVendor = vendorService.save(v);
        return ResponseEntity.ok().body(newVendor);
    }

    @GetMapping // Metodo para obtener el listado de vendors
    public List<Vendor> obtenerVendors() {
        return vendorService.findAll();
    }

    @DeleteMapping // Metodo para eliminar todos los vendors
    public ResponseEntity<String> deleteAll() {
        vendorService.deleteAll();
        return ResponseEntity.ok().body("Se eliminaron todos los vendors");
    }

    @PutMapping("/{id}") // Metodo para actualizar un vendor por su id
    public ResponseEntity<Vendor> updateVendor(@PathVariable UUID id, @RequestBody Vendor vendor) {
        Vendor updatedVendor = vendorService.update(id, vendor);
        return ResponseEntity.ok().body(updatedVendor);
    }
}
*/
