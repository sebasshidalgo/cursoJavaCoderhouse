package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.controller;

import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto.BranchCreateDTO;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto.BranchResponseDTO;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.service.BranchService;
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
    public ResponseEntity<BranchResponseDTO> createBranch(@PathVariable UUID vendorId, @RequestBody @Valid BranchCreateDTO branchDTO) {
        BranchResponseDTO response = branchService.createBranch(branchDTO, vendorId);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping  // Metodo para obtener el listado de sucursales
    public ResponseEntity<List<BranchResponseDTO>> getAllBranches() {
        return ResponseEntity.ok(branchService.getAllBranches());
    }

    @GetMapping("/{id}") // Metodo para obtener una sucursal por su id
    public ResponseEntity<BranchResponseDTO> getBranchById(@PathVariable UUID id) {
        return ResponseEntity.ok(branchService.getBranchById(id));
    }

    @PutMapping("/{id}")  // Metodo para actualizar una sucursal existente por su ID
    public ResponseEntity<BranchResponseDTO> updateBranch(@PathVariable UUID id, @Valid @RequestBody BranchCreateDTO branchDTO) {
        return ResponseEntity.ok(branchService.updateBranch(id, branchDTO));
    }

    @DeleteMapping("/{id}")    // Metodo para eliminar una sucursal específica por su id
    public ResponseEntity<String> deleteBranch(@PathVariable UUID id) {
        branchService.deleteBranchById(id);
        return ResponseEntity.ok("✅ Sucursal eliminada correctamente");
    }

    @DeleteMapping // Metodo para eliminar todas las sucursales
    public ResponseEntity<String> deleteAllBranches() {
        branchService.deleteAllBranches();
        return ResponseEntity.ok("✅ Todas las sucursales han sido eliminadas correctamente");
    }
}
