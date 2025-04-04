package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.controller;

import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto.AddressCreateDTO;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto.AddressResponseDTO;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.service.AddressService;
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
    @Operation(summary = "Create address", description = "Método para crear una nueva dirección asociada a un proveedor")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Dirección creada correctamente", // Respuesta exitosa
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = AddressResponseDTO.class)
                    )
            ),
            @ApiResponse(responseCode = "400", description = "Datos inválidos"), // Error de validación
            @ApiResponse(responseCode = "500", description = "Error interno del servidor") // Error del servidor
    })
    public ResponseEntity<AddressResponseDTO> createAddress(
            @PathVariable UUID vendorId,
            @io.swagger.v3.oas.annotations.parameters.RequestBody( // Descripción del cuerpo de la solicitud
                    description = "Datos de la nueva dirección",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = AddressCreateDTO.class)
                    )
            )
            @RequestBody @Valid AddressCreateDTO addressDTO) {
        AddressResponseDTO response = addressService.createAddress(addressDTO, vendorId);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Metodo para obtener el listado de direcciones
    @GetMapping
    @Operation(summary = "Get all addresses", description = "Método para obtener el listado de todas las direcciones")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Listado de direcciones obtenidas correctamente", // Respuesta exitosa
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = AddressResponseDTO.class))
                    )
            ),
            @ApiResponse(responseCode = "204", description = "No hay direcciones disponibles en la DB"), // No content
            @ApiResponse(responseCode = "400", description = "Datos inválidos"), // Error de validación
            @ApiResponse(responseCode = "404", description = "No se encontraron direcciones"), // No encontrado
            @ApiResponse(responseCode = "500", description = "Error interno del servidor") // Error del servidor
    })
    public ResponseEntity<List<AddressResponseDTO>> getAllAddresses() {
        return ResponseEntity.ok(addressService.getAllAddresses());
    }

    // Metodo para obtener una dirección por su ID
    @GetMapping("/{id}")
    @Operation(summary = "Get address by ID", description = "Método para obtener una dirección por su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Dirección obtenida correctamente", // Respuesta exitosa
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = AddressResponseDTO.class)
                    )
            ),
            @ApiResponse(responseCode = "204", description = "No hay direcciones disponibles en la DB"), // No content
            @ApiResponse(responseCode = "400", description = "Datos inválidos"), // Error de validación
            @ApiResponse(responseCode = "404", description = "No se encontró la dirección solicitada"), // No encontrado
            @ApiResponse(responseCode = "500", description = "Error interno del servidor") // Error del servidor
    })
    public ResponseEntity<AddressResponseDTO> getAddressById(@PathVariable Long id) {
        return ResponseEntity.ok(addressService.getAddressById(id));
    }

    // Metodo para actualizar una dirección por su ID
    @PutMapping("/{id}")
    @Operation(summary = "Update address", description = "Método para actualizar una dirección por su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Dirección actualizada correctamente", // Respuesta exitosa
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = AddressResponseDTO.class)
                    )
            ),
            @ApiResponse(responseCode = "400", description = "Datos inválidos"), // Error de validación
            @ApiResponse(responseCode = "404", description = "No se encontró la dirección solicitada"), // No encontrado
            @ApiResponse(responseCode = "500", description = "Error interno del servidor") // Error del servidor
    })
    public ResponseEntity<AddressResponseDTO> updateAddress(@PathVariable Long id, @Valid @RequestBody AddressCreateDTO addressDTO) {
        return ResponseEntity.ok(addressService.updateAddress(id, addressDTO));
    }

    // Metodo para eliminar una dirección por su ID
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete address", description = "Método para eliminar una dirección por su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Dirección eliminada correctamente"), // Respuesta exitosa
            @ApiResponse(responseCode = "400", description = "Datos inválidos"), // Error de validación
            @ApiResponse(responseCode = "404", description = "No se encontró la dirección solicitada"), // No encontrado
            @ApiResponse(responseCode = "500", description = "Error interno del servidor") // Error del servidor
    })
    public ResponseEntity<String> deleteAddress(@PathVariable Long id) {
        addressService.deleteAddressById(id);
        return ResponseEntity.ok("✅ Dirección eliminada correctamente");
    }

    // Metodo para eliminar todas las direcciones
    @DeleteMapping
    @Operation(summary = "Delete all addresses", description = "Método para eliminar todas las direcciones")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Todas las direcciones fueron eliminadas correctamente"), // Respuesta exitosa
            @ApiResponse(responseCode = "204", description = "No hay direcciones disponibles en la DB"), // No content
            @ApiResponse(responseCode = "400", description = "Datos inválidos"), // Error de validación
            @ApiResponse(responseCode = "500", description = "Error interno del servidor") // Error del servidor
    })
    public ResponseEntity<String> deleteAllAddresses() {
        addressService.deleteAllAddresses();
        return ResponseEntity.ok("✅ Todas las direcciones han sido eliminadas correctamente");
    }
}

