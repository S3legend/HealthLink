package com.healthlink.doctorservice.controller;

import com.healthlink.doctorservice.dto.doctorDTO;
import com.healthlink.doctorservice.dto.doctorResponseDTO;
import com.healthlink.doctorservice.service.doctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class doctorController {
    private final doctorService doctorService;

    public doctorController(doctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public ResponseEntity<List<doctorResponseDTO>> getAlldoctors() {
        return ResponseEntity.ok(doctorService.getAlldoctors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<doctorResponseDTO> getdoctorById(@PathVariable Long id) {
        return ResponseEntity.ok(doctorService.getdoctorById(id));
    }

    @PostMapping
    public ResponseEntity<doctorResponseDTO> createdoctor(@RequestBody doctorDTO doctorDTO) {
        return ResponseEntity.ok(doctorService.createdoctor(doctorDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<doctorResponseDTO> updatedoctor(@PathVariable Long id, @RequestBody doctorDTO updateddoctorDTO) {
        return ResponseEntity.ok(doctorService.updatedoctor(id, updateddoctorDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletedoctor(@PathVariable Long id) {
        doctorService.deletedoctor(id);
        return ResponseEntity.noContent().build();
    }
}