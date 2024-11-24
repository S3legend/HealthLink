package com.healthlink.patientservice.service;

import com.healthlink.patientservice.dto.PatientDTO;
import com.healthlink.patientservice.dto.PatientResponseDTO;
import com.healthlink.patientservice.entity.Patient;
import com.healthlink.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDTO> getAllPatients() {
        return patientRepository.findAll()
                .stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public PatientResponseDTO getPatientById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with ID: " + id));
        return convertToResponseDTO(patient);
    }

    public PatientResponseDTO createPatient(PatientDTO patientDTO) {
        Patient patient = convertToEntity(patientDTO);
        Patient savedPatient = patientRepository.save(patient);
        return convertToResponseDTO(savedPatient);
    }

    public PatientResponseDTO updatePatient(Long id, PatientDTO updatedPatientDTO) {
        Patient existingPatient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with ID: " + id));

        existingPatient.setFirstName(updatedPatientDTO.getFirstName());
        existingPatient.setLastName(updatedPatientDTO.getLastName());
        existingPatient.setEmail(updatedPatientDTO.getEmail());
        existingPatient.setPhone(updatedPatientDTO.getPhone());
        existingPatient.setAddress(updatedPatientDTO.getAddress());
        existingPatient.setCity(updatedPatientDTO.getCity());
        existingPatient.setCountry(updatedPatientDTO.getCountry());

        Patient updatedPatient = patientRepository.save(existingPatient);
        return convertToResponseDTO(updatedPatient);
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    private PatientResponseDTO convertToResponseDTO(Patient patient) {
        PatientResponseDTO dto = new PatientResponseDTO();
        dto.setId(patient.getId());
        dto.setFirstName(patient.getFirstName());
        dto.setLastName(patient.getLastName());
        dto.setEmail(patient.getEmail());
        dto.setPhone(patient.getPhone());
        dto.setAddress(patient.getAddress());
        dto.setCity(patient.getCity());
        dto.setCountry(patient.getCountry());
        return dto;
    }

    private Patient convertToEntity(PatientDTO patientDTO) {
        Patient patient = new Patient();
        patient.setFirstName(patientDTO.getFirstName());
        patient.setLastName(patientDTO.getLastName());
        patient.setEmail(patientDTO.getEmail());
        patient.setPhone(patientDTO.getPhone());
        patient.setAddress(patientDTO.getAddress());
        patient.setCity(patientDTO.getCity());
        patient.setCountry(patientDTO.getCountry());
        return patient;
    }
}