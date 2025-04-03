package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.controller;

import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto.VendorCreateDTO;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto.VendorResponseDTO;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto.VendorUpdateDTO;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.model.Vendor;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.service.VendorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/vendors")  // Ruta base para acceder a los endpoints
@Validated // Validación de los datos de entrada
public class VendorController {
    @Autowired
    private VendorService vendorService; // Inyección de dependencia

    @PostMapping // Metodo para crear un nuevo vendor
    public ResponseEntity<VendorResponseDTO> newVendor(@RequestBody @Valid VendorCreateDTO v) {
        VendorResponseDTO newVendor = vendorService.createVendor(v);
        return ResponseEntity.status(HttpStatus.CREATED).body(newVendor);
    }

    @PutMapping("/{id}") // Metodo para actualizar un vendor existente por su ID
    public ResponseEntity<VendorResponseDTO> updateVendor(@PathVariable UUID id, @Valid @RequestBody VendorUpdateDTO updateDTO) {
        VendorResponseDTO updatedVendor = vendorService.updateVendor(id, updateDTO);
        return ResponseEntity.ok(updatedVendor);
    }

    @GetMapping // Metodo para obtener el listado de vendors
    public ResponseEntity<List<VendorResponseDTO>> getAllVendors() {
        List<VendorResponseDTO> vendors = vendorService.getAllVendors();
        return ResponseEntity.ok().body(vendors);
    }

    @GetMapping("/{id}") // Metodo para obtener un vendor específico
    public ResponseEntity<VendorResponseDTO> getVendorById(@PathVariable UUID id) {
        VendorResponseDTO vendor = vendorService.getVendorById(id);
        return ResponseEntity.ok(vendor);
    }

    @DeleteMapping // Metodo para eliminar todos los vendors
    public ResponseEntity<String> deleteAllVendors() {
        String response = vendorService.deleteAllVendors();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}") // Metodo para eliminar un vendor específico
    public ResponseEntity<String> deleteVendor(@PathVariable UUID id) {
        vendorService.deleteVendorById(id);
        return ResponseEntity.ok("✅ Proveedor eliminado correctamente");
    }
}

