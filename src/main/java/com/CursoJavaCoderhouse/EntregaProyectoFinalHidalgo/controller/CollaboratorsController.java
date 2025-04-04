package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.controller;

import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto.CollaboratorsCreateDTO;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto.CollaboratorsResponseDTO;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.service.CollaboratorsService;
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
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/collaborators")
public class CollaboratorsController {
    @Autowired
    private CollaboratorsService collaboratorsService; // Inyección de dependencias

    // Crear un nuevo colaborador
    @PostMapping
    @Operation(summary = "Create collaborator", description = "Método para crear un nuevo colaborador en la DB")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Colaborador creado correctamente", // Respuesta exitosa
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CollaboratorsResponseDTO.class)
                    )
            ),
            @ApiResponse(responseCode = "400", description = "Datos inválidos"), // Error de validación
            @ApiResponse(responseCode = "500", description = "Error interno del servidor") // Error del servidor
    })
    public ResponseEntity<CollaboratorsResponseDTO> createCollaborator(
            @io.swagger.v3.oas.annotations.parameters.RequestBody( // Descripción del cuerpo de la solicitud
                    description = "Datos del nuevo colaborador",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CollaboratorsCreateDTO.class)
                    )
            )
            @RequestBody @Valid CollaboratorsCreateDTO collaboratorDTO) {
        CollaboratorsResponseDTO response = collaboratorsService.createCollaborator(collaboratorDTO, collaboratorDTO.getVendorId());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Obtener lista de colaboradores
    @GetMapping
    @Operation(summary = "Get all collaborators", description = "Método para obtener el listado de todos los colaboradores de la DB")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de colaboradores obtenida correctamente", // Respuesta exitosa
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = CollaboratorsResponseDTO.class))
                    )
            ),
            @ApiResponse(responseCode = "204", description = "No hay colaboradores disponibles en la DB"), // No content
            @ApiResponse(responseCode = "400", description = "Datos inválidos"), // Error de validación
            @ApiResponse(responseCode = "404", description = "No se encontraron colaboradores"), // No encontrado
            @ApiResponse(responseCode = "500", description = "Error interno del servidor") // Error del servidor
    })
    public ResponseEntity<List<CollaboratorsResponseDTO>> getAllCollaborators() {
        return ResponseEntity.ok(collaboratorsService.getAllCollaborators());
    }

    // Obtener un colaborador por ID
    @GetMapping("/{id}")
    @Operation(summary = "Get collaborator by ID", description = "Método para obtener un colaborador por su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Colaborador encontrado correctamente", // Respuesta exitosa
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CollaboratorsResponseDTO.class)
                    )
            ),
            @ApiResponse(responseCode = "400", description = "Datos inválidos"), // Error de validación
            @ApiResponse(responseCode = "404", description = "Colaborador no encontrado"), // No encontrado
            @ApiResponse(responseCode = "500", description = "Error interno del servidor") // Error del servidor
    })
    public ResponseEntity<CollaboratorsResponseDTO> getCollaboratorById(@PathVariable Long id) {
        return ResponseEntity.ok(collaboratorsService.getCollaboratorById(id));
    }

    // Actualizar un colaborador por ID
    @PutMapping("/{id}")
    @Operation(summary = "Update collaborator", description = "Método para actualizar un colaborador por su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Colaborador actualizado correctamente", // Respuesta exitosa
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CollaboratorsResponseDTO.class)
                    )
            ),
            @ApiResponse(responseCode = "400", description = "Datos inválidos"), // Error de validación
            @ApiResponse(responseCode = "404", description = "Colaborador no encontrado"), // No encontrado
            @ApiResponse(responseCode = "500", description = "Error interno del servidor") // Error del servidor
    })
    public ResponseEntity<CollaboratorsResponseDTO> updateCollaborator(
            @PathVariable Long id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody( // Descripción del cuerpo de la solicitud
                    description = "Datos del colaborador a actualizar",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CollaboratorsCreateDTO.class)
                    )
            )
            @Valid @RequestBody CollaboratorsCreateDTO collaboratorDTO) {
        return ResponseEntity.ok(collaboratorsService.updateCollaborator(id, collaboratorDTO));
    }

    // Eliminar un colaborador por ID
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete collaborator", description = "Método para eliminar un colaborador por su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Colaborador eliminado correctamente"), // Respuesta exitosa
            @ApiResponse(responseCode = "400", description = "Datos inválidos"), // Error de validación
            @ApiResponse(responseCode = "404", description = "Colaborador no encontrado"), // No encontrado
            @ApiResponse(responseCode = "500", description = "Error interno del servidor") // Error del servidor
    })
    public ResponseEntity<String> deleteCollaborator(@PathVariable Long id) {
        collaboratorsService.deleteCollaboratorById(id);
        return ResponseEntity.ok("✅ Colaborador eliminado correctamente");
    }

    // Eliminar todos los colaboradores
    @DeleteMapping
    @Operation(summary = "Delete all collaborators", description = "Método para eliminar todos los colaboradores de la DB")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Todos los colaboradores fueron eliminados correctamente"), // Respuesta exitosa
            @ApiResponse(responseCode = "204", description = "No hay colaboradores registrados"), // Sin contenido
            @ApiResponse(responseCode = "400", description = "Datos inválidos"), // Error de validación
            @ApiResponse(responseCode = "500", description = "Error interno del servidor") // Error del servidor
    })
    public ResponseEntity<String> deleteAllCollaborators() {
        collaboratorsService.deleteAllCollaborators();
        return ResponseEntity.ok("✅ Todos los colaboradores han sido eliminados correctamente");
    }
}
