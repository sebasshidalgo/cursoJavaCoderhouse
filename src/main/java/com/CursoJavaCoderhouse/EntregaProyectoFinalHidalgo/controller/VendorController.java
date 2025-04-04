package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.controller;

import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto.VendorCreateDTO;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto.VendorResponseDTO;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto.VendorUpdateDTO;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.model.Vendor;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.service.VendorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @PostMapping  // Metodo para crear un nuevo vendor
    @Operation(summary = "Create vendor", description = "Método para crear un nuevo vendor en la DB")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Vendor creado correctamente",  // Respuesta exitosa
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = VendorResponseDTO.class)
                    )
            ),
            @ApiResponse(responseCode = "400", description = "Datos inválidos"), // Error de validación
            @ApiResponse(responseCode = "500", description = "Error interno del servidor") // Error del servidor
    })
    public ResponseEntity<VendorResponseDTO> newVendor(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(  // Descripción del cuerpo de la solicitud
                    description = "Datos del nuevo vendor",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = VendorCreateDTO.class)
                    )
                )
            @RequestBody @Valid VendorCreateDTO v) {
        VendorResponseDTO newVendor = vendorService.createVendor(v);
        return ResponseEntity.status(HttpStatus.CREATED).body(newVendor);
    }

    @PutMapping("/{id}") // Metodo para actualizar un vendor existente por su ID
    @Operation(summary = "Update vendor", description = "Método para actualizar un vendor existente en la DB")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Vendor actualizado correctamente", // Respuesta exitosa
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = VendorResponseDTO.class)
                    )
            ),
            @ApiResponse(responseCode = "400", description = "Datos inválidos"), // Error de validación
            @ApiResponse(responseCode = "404", description = "Vendor no encontrado"), // No encontrado
            @ApiResponse(responseCode = "500", description = "Error interno del servidor") // Error del servidor
    })
    public ResponseEntity<VendorResponseDTO> updateVendor(
            @PathVariable UUID id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody( // Descripción del cuerpo de la solicitud
                    description = "Datos del vendor a actualizar",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = VendorUpdateDTO.class)
                    )
            )
            @Valid @RequestBody VendorUpdateDTO updateDTO) {
        VendorResponseDTO updatedVendor = vendorService.updateVendor(id, updateDTO);
        return ResponseEntity.ok(updatedVendor);
    }

    @GetMapping // Metodo para obtener el listado de vendors
    @Operation(summary = "Get all vendors", description = "Método para obtener el listado de todos los vendors de la DB")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Listado de vendors obtenido correctamente", // Respuesta exitosa
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = VendorResponseDTO.class))
                    )
            ),
            @ApiResponse(responseCode = "204", description = "No hay vendors registrados en la DB"), // Sin contenido
            @ApiResponse(responseCode = "400", description = "Datos inválidos"), // Error de validación
            @ApiResponse(responseCode = "500", description = "Error interno del servidor") // Error del servidor
    })
    public ResponseEntity<List<VendorResponseDTO>> getAllVendors() {
        List<VendorResponseDTO> vendors = vendorService.getAllVendors();
        return ResponseEntity.ok().body(vendors);
    }

    @GetMapping("/{id}") // Metodo para obtener un vendor específico
    @Operation(summary = "Get vendor by ID", description = "Método para obtener un vendor específico por su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Vendor encontrado correctamente", // Respuesta exitosa
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = VendorResponseDTO.class)
                    )
            ),
            @ApiResponse(responseCode = "204", description = "No hay vendors registrados"), // Sin contenido
            @ApiResponse(responseCode = "400", description = "ID inválido"), // Error de validación
            @ApiResponse(responseCode = "404", description = "Vendor no encontrado"), // No encontrado
            @ApiResponse(responseCode = "500", description = "Error interno del servidor") // Error del servidor
    })
    public ResponseEntity<VendorResponseDTO> getVendorById(@PathVariable UUID id) {
        VendorResponseDTO vendor = vendorService.getVendorById(id);
        return ResponseEntity.ok(vendor);
    }

    @DeleteMapping // Metodo para eliminar todos los vendors
    @Operation(summary = "Delete all vendors", description = "Método para eliminar todos los vendors de la DB")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Todos los vendors fueron eliminados correctamente"), // Respuesta exitosa
            @ApiResponse(responseCode = "400", description = "Datos inválidos"), // Error de validación
            @ApiResponse(responseCode = "500", description = "Error interno del servidor") // Error del servidor
    })
    public ResponseEntity<String> deleteAllVendors() {
        String response = vendorService.deleteAllVendors();
        return ResponseEntity.ok("✅ Todos los proveedores fueron eliminados correctamente");
    }

    @DeleteMapping("/{id}") // Metodo para eliminar un vendor específico
    @Operation(summary = "Delete vendor by ID", description = "Método para eliminar un vendor específico por su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Vendor eliminado correctamente"), // Respuesta exitosa
            @ApiResponse(responseCode = "400", description = "ID inválido"), // Error de validación
            @ApiResponse(responseCode = "404", description = "Vendor no encontrado"), // No encontrado
            @ApiResponse(responseCode = "500", description = "Error interno del servidor") // Error del servidor
    })
    public ResponseEntity<String> deleteVendor(@PathVariable UUID id) {
        vendorService.deleteVendorById(id);
        return ResponseEntity.ok("✅ Proveedor eliminado correctamente");
    }
}

