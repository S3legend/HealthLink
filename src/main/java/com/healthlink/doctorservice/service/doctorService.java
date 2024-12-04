package com.healthlink.doctorservice.service;

import com.healthlink.doctorservice.dto.doctorDTO;
import com.healthlink.doctorservice.dto.doctorResponseDTO;
import com.healthlink.doctorservice.entity.doctor;
import com.healthlink.doctorservice.repository.doctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class doctorService {
    private final doctorRepository doctorRepository;

    public doctorService(doctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<doctorResponseDTO> getAlldoctors() {
        return doctorRepository.findAll()
                .stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public doctorResponseDTO getdoctorById(Long id) {
        doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("doctor not found with ID: " + id));
        return convertToResponseDTO(doctor);
    }

    public doctorResponseDTO createdoctor(doctorDTO doctorDTO) {
        doctor doctor = convertToEntity(doctorDTO);
        doctor saveddoctor = doctorRepository.save(doctor);
        return convertToResponseDTO(saveddoctor);
    }

    public doctorResponseDTO updatedoctor(Long id, doctorDTO updateddoctorDTO) {
        doctor existingdoctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("doctor not found with ID: " + id));

        existingdoctor.setFirstName(updateddoctorDTO.getFirstName());
        existingdoctor.setLastName(updateddoctorDTO.getLastName());
        existingdoctor.setEmail(updateddoctorDTO.getEmail());
        existingdoctor.setPhone(updateddoctorDTO.getPhone());
        existingdoctor.setAddress(updateddoctorDTO.getAddress());
        existingdoctor.setCity(updateddoctorDTO.getCity());
        existingdoctor.setCountry(updateddoctorDTO.getCountry());

        doctor updateddoctor = doctorRepository.save(existingdoctor);
        return convertToResponseDTO(updateddoctor);
    }

    public void deletedoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    private doctorResponseDTO convertToResponseDTO(doctor doctor) {
        doctorResponseDTO dto = new doctorResponseDTO();
        dto.setId(doctor.getId());
        dto.setFirstName(doctor.getFirstName());
        dto.setLastName(doctor.getLastName());
        dto.setEmail(doctor.getEmail());
        dto.setPhone(doctor.getPhone());
        dto.setAddress(doctor.getAddress());
        dto.setCity(doctor.getCity());
        dto.setCountry(doctor.getCountry());
        return dto;
    }

    private doctor convertToEntity(doctorDTO doctorDTO) {
        doctor doctor = new doctor();
        doctor.setFirstName(doctorDTO.getFirstName());
        doctor.setLastName(doctorDTO.getLastName());
        doctor.setEmail(doctorDTO.getEmail());
        doctor.setPhone(doctorDTO.getPhone());
        doctor.setAddress(doctorDTO.getAddress());
        doctor.setCity(doctorDTO.getCity());
        doctor.setCountry(doctorDTO.getCountry());
        doctor.setDoctorPassword(doctorDTO.getDoctorPassword());
        doctor.setSpecialization(doctorDTO.getSpecialization());
        doctor.setCountry(String.valueOf(doctorDTO.getEndTimeOfWork()));


        return doctor;
    }
}