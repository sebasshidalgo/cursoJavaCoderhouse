package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.controller;

import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto.BranchCreateDTO;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto.BranchResponseDTO;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.service.BranchService;
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
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/branches") // Ruta base para acceder a los endpoints
@Validated // Validación de los datos de entrada
public class BranchController {
    @Autowired
    private BranchService branchService; // Inyección de dependencia

    @PostMapping("/{vendorId}") // Metodo para crear una nueva sucursal
    @Operation(summary = "Create branch", description = "Crea una nueva sucursal asociada a un proveedor")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Sucursal creada correctamente", // Respuesta exitosa
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = BranchResponseDTO.class)
                    )
            ),
            @ApiResponse(responseCode = "400", description = "Datos inválidos"), // Error de validación
            @ApiResponse(responseCode = "404", description = "Proveedor no encontrado"), // Proveedor no encontrado
            @ApiResponse(responseCode = "500", description = "Error interno del servidor") // Error del servidor
    })
    public ResponseEntity<BranchResponseDTO> createBranch(
            @PathVariable UUID vendorId,
            @io.swagger.v3.oas.annotations.parameters.RequestBody( // Descripción del cuerpo de la solicitud
                    description = "Datos de la nueva sucursal",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = BranchCreateDTO.class)
                    )
            )
            @RequestBody @Valid BranchCreateDTO branchDTO) {
        BranchResponseDTO response = branchService.createBranch(branchDTO, vendorId);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping  // Metodo para obtener el listado de sucursales
    @Operation(summary = "Get all branches", description = "Obtiene el listado de todas las sucursales")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Listado de sucursales obtenidas correctamente", // Respuesta exitosa
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = BranchResponseDTO.class))
                    )
            ),
            @ApiResponse(responseCode = "204", description = "No hay sucursales disponibles en la DB"), // No content
            @ApiResponse(responseCode = "400", description = "Datos inválidos"), // Error de validación
            @ApiResponse(responseCode = "404", description = "No se encontraron sucursales"), // Not found
            @ApiResponse(responseCode = "500", description = "Error interno del servidor") // Error del servidor
    })
    public ResponseEntity<List<BranchResponseDTO>> getAllBranches() {
        return ResponseEntity.ok(branchService.getAllBranches());
    }

    @GetMapping("/{id}") // Metodo para obtener una sucursal por su id
    @Operation(summary = "Get branch by ID", description = "Obtiene una sucursal por su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Sucursal obtenida correctamente", // Respuesta exitosa
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = BranchResponseDTO.class)
                    )
            ),
            @ApiResponse(responseCode = "400", description = "Datos inválidos"), // Error de validación
            @ApiResponse(responseCode = "404", description = "Sucursal no encontrada"), // Not found
            @ApiResponse(responseCode = "500", description = "Error interno del servidor") // Error del servidor
    })
    public ResponseEntity<BranchResponseDTO> getBranchById(@PathVariable UUID id) {
        return ResponseEntity.ok(branchService.getBranchById(id));
    }

    @PutMapping("/{id}")  // Metodo para actualizar una sucursal existente por su ID
    @Operation(summary = "Update branch", description = "Actualiza una sucursal existente por su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Sucursal actualizada correctamente", // Respuesta exitosa
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = BranchResponseDTO.class)
                    )
            ),
            @ApiResponse(responseCode = "400", description = "Datos inválidos"), // Error de validación
            @ApiResponse(responseCode = "404", description = "Sucursal no encontrada"), // Not found
            @ApiResponse(responseCode = "500", description = "Error interno del servidor") // Error del servidor
    })
    public ResponseEntity<BranchResponseDTO> updateBranch(
            @PathVariable UUID id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody( // Descripción del cuerpo de la solicitud
                    description = "Datos de la sucursal a actualizar",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = BranchCreateDTO.class)
                    )
            )
            @Valid @RequestBody BranchCreateDTO branchDTO) {
        return ResponseEntity.ok(branchService.updateBranch(id, branchDTO));
    }

    @DeleteMapping("/{id}")    // Metodo para eliminar una sucursal específica por su id
    @Operation(summary = "Delete branch", description = "Elimina una sucursal por su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Sucursal eliminada correctamente"), // Respuesta exitosa
            @ApiResponse(responseCode = "400", description = "Datos inválidos"), // Error de validación
            @ApiResponse(responseCode = "404", description = "Sucursal no encontrada"), // Not found
            @ApiResponse(responseCode = "500", description = "Error interno del servidor") // Error del servidor
    })
    public ResponseEntity<String> deleteBranch(@PathVariable UUID id) {
        branchService.deleteBranchById(id);
        return ResponseEntity.ok("✅ Sucursal eliminada correctamente");
    }

    @DeleteMapping // Metodo para eliminar todas las sucursales
    @Operation(summary = "Delete all branches", description = "Elimina todas las sucursales")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Todas las sucursales eliminadas correctamente"), // Respuesta exitosa
            @ApiResponse(responseCode = "400", description = "Datos inválidos"), // Error de validación
            @ApiResponse(responseCode = "404", description = "No se encontraron sucursales"), // Not found
            @ApiResponse(responseCode = "500", description = "Error interno del servidor") // Error del servidor
    })
    public ResponseEntity<String> deleteAllBranches() {
        branchService.deleteAllBranches();
        return ResponseEntity.ok("✅ Todas las sucursales han sido eliminadas correctamente");
    }
}
