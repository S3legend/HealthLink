package com.healthlink.consultation.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ConsultationDTO {
    private Long id;
    private String patientName;
    private String doctorName;
    private LocalDateTime appointmentTime;
    private String status;
    private String notes;


}

