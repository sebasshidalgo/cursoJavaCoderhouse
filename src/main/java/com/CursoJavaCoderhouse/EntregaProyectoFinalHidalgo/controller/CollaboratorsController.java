package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.controller;

import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto.CollaboratorsCreateDTO;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto.CollaboratorsResponseDTO;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.service.CollaboratorsService;
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
    public ResponseEntity<CollaboratorsResponseDTO> createCollaborator(@RequestBody @Valid CollaboratorsCreateDTO collaboratorDTO) {
        CollaboratorsResponseDTO response = collaboratorsService.createCollaborator(collaboratorDTO, collaboratorDTO.getVendorId());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Obtener lista de colaboradores
    @GetMapping
    public ResponseEntity<List<CollaboratorsResponseDTO>> getAllCollaborators() {
        return ResponseEntity.ok(collaboratorsService.getAllCollaborators());
    }

    // Obtener un colaborador por ID
    @GetMapping("/{id}")
    public ResponseEntity<CollaboratorsResponseDTO> getCollaboratorById(@PathVariable Long id) {
        return ResponseEntity.ok(collaboratorsService.getCollaboratorById(id));
    }

    // Actualizar un colaborador por ID
    @PutMapping("/{id}")
    public ResponseEntity<CollaboratorsResponseDTO> updateCollaborator(@PathVariable Long id, @Valid @RequestBody CollaboratorsCreateDTO collaboratorDTO) {
        return ResponseEntity.ok(collaboratorsService.updateCollaborator(id, collaboratorDTO));
    }

    // Eliminar un colaborador por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCollaborator(@PathVariable Long id) {
        collaboratorsService.deleteCollaboratorById(id);
        return ResponseEntity.ok("✅ Colaborador eliminado correctamente");
    }

    // Eliminar todos los colaboradores
    @DeleteMapping
    public ResponseEntity<String> deleteAllCollaborators() {
        collaboratorsService.deleteAllCollaborators();
        return ResponseEntity.ok("✅ Todos los colaboradores han sido eliminados correctamente");
    }
}
