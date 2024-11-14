package com.healthlink.appointments.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentDTO {
    private Long patientId;
    private Long doctorId;
    private LocalDateTime appointmentDateTime;
    private String notes;
    private LocalDateTime modifiedDateTime;
}
