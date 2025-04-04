package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.controller;

import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto.AddressCreateDTO;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto.AddressResponseDTO;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/address") // Ruta base para acceder a los endpoints
public class AddressController {

    @Autowired
    private AddressService addressService; // Inyección de dependencia

    // Metodo para crear una nueva dirección asociada a un proveedor
    @PostMapping("/{vendorId}")
    public ResponseEntity<AddressResponseDTO> createAddress(@PathVariable UUID vendorId, @RequestBody @Valid AddressCreateDTO addressDTO) {
        AddressResponseDTO response = addressService.createAddress(addressDTO, vendorId);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Metodo para obtener el listado de direcciones
    @GetMapping
    public ResponseEntity<List<AddressResponseDTO>> getAllAddresses() {
        return ResponseEntity.ok(addressService.getAllAddresses());
    }

    // Metodo para obtener una dirección por su ID
    @GetMapping("/{id}")
    public ResponseEntity<AddressResponseDTO> getAddressById(@PathVariable Long id) {
        return ResponseEntity.ok(addressService.getAddressById(id));
    }

    // Metodo para actualizar una dirección por su ID
    @PutMapping("/{id}")
    public ResponseEntity<AddressResponseDTO> updateAddress(@PathVariable Long id, @Valid @RequestBody AddressCreateDTO addressDTO) {
        return ResponseEntity.ok(addressService.updateAddress(id, addressDTO));
    }

    // Metodo para eliminar una dirección por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable Long id) {
        addressService.deleteAddressById(id);
        return ResponseEntity.ok("✅ Dirección eliminada correctamente");
    }

    // Metodo para eliminar todas las direcciones
    @DeleteMapping
    public ResponseEntity<String> deleteAllAddresses() {
        addressService.deleteAllAddresses();
        return ResponseEntity.ok("✅ Todas las direcciones han sido eliminadas correctamente");
    }
}

