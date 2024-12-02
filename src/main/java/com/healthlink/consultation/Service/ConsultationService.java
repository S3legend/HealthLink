package com.healthlink.consultation.Service;

import com.healthlink.consultation.dto.ConsultationDTO;
import com.healthlink.consultation.entity.Consultation;
import com.healthlink.consultation.exception.ConsultationNotFoundException;
import com.healthlink.consultation.repository.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsultationService {

    @Autowired
    private ConsultationRepository repository;

    public ConsultationDTO createConsultation(ConsultationDTO dto) {
        Consultation consultation = new Consultation();
        consultation.setPatientName(dto.getPatientName());
        consultation.setDoctorName(dto.getDoctorName());
        consultation.setAppointmentTime(dto.getAppointmentTime());
        consultation.setStatus("Pending");
        consultation.setNotes(dto.getNotes());

        Consultation savedConsultation = repository.save(consultation);

        return mapToDTO(savedConsultation);
    }

    public List<ConsultationDTO> getAllConsultations() {
        return repository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public ConsultationDTO getConsultationById(Long id) {
        Consultation consultation = repository.findById(id)
                .orElseThrow(() -> new ConsultationNotFoundException("Consultation not found with ID: " + id));
        return mapToDTO(consultation);
    }

    public void deleteConsultation(Long id) {
        repository.deleteById(id);
    }

    private ConsultationDTO mapToDTO(Consultation consultation) {
        ConsultationDTO dto = new ConsultationDTO();
        dto.setId(consultation.getId());
        dto.setPatientName(consultation.getPatientName());
        dto.setDoctorName(consultation.getDoctorName());
        dto.setAppointmentTime(consultation.getAppointmentTime());
        dto.setStatus(consultation.getStatus());
        dto.setNotes(consultation.getNotes());
        return dto;
    }
}

