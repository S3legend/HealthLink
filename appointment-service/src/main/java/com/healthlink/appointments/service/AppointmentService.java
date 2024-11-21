package com.healthlink.appointments.service;

import com.healthlink.appointments.dto.AppointmentDTO;
import com.healthlink.appointments.entity.Appointment;
import com.healthlink.appointments.enums.AppointmentStatus;
import com.healthlink.appointments.repository.AppointmentRepository;
import com.healthlink.appointments.exception.AppointmentNotFoundException;
import com.healthlink.appointments.exception.SchedulingConflictException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Transactional
    public Appointment createAppointment(AppointmentDTO appointmentDTO) {
        validateAvailability(appointmentDTO);

        Appointment appointment = new Appointment();
        appointment.setPatientId(appointmentDTO.getPatientId());
        appointment.setDoctorId(appointmentDTO.getDoctorId());
        appointment.setAppointmentDateTime(appointmentDTO.getAppointmentDateTime());
        appointment.setStatus(AppointmentStatus.SCHEDULED); // Default status for new appointments
        appointment.setNotes(appointmentDTO.getNotes());

        log.info("Creating appointment for patientId={} and doctorId={}",
                appointmentDTO.getPatientId(), appointmentDTO.getDoctorId());
        return appointmentRepository.save(appointment);
    }

    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new AppointmentNotFoundException("Appointment not found with ID: " + id));
    }

    public Appointment confirmAppointment(Long id) {
        Appointment appointment = getAppointmentById(id);
        appointment.setStatus(AppointmentStatus.CONFIRMED);
        log.info("Confirming appointment with ID={}", id);
        return appointmentRepository.save(appointment);
    }

    @Transactional
    public Appointment updateAppointment(Long id, AppointmentDTO appointmentDTO) {
        Appointment appointment = getAppointmentById(id);

        validateAvailability(appointmentDTO);

        appointment.setAppointmentDateTime(appointmentDTO.getAppointmentDateTime());
        appointment.setNotes(appointmentDTO.getNotes());
        log.info("Updating appointment with ID={} to new dateTime={}", id, appointmentDTO.getAppointmentDateTime());
        return appointmentRepository.save(appointment);
    }

    @Transactional
    public Appointment modifyAppointment(Long id, LocalDateTime newDateTime) {
        Appointment appointment = getAppointmentById(id);
        appointment.setModifiedDateTime(newDateTime);
        appointment.setStatus(AppointmentStatus.MODIFIED);
        log.info("Modifying appointment with ID={} to new dateTime={}", id, newDateTime);
        return appointmentRepository.save(appointment);
    }

    @Transactional
    public void cancelAppointment(Long id) {
        Appointment appointment = getAppointmentById(id);
        appointment.setStatus(AppointmentStatus.CANCELED); // Set status to CANCELED
        log.info("Cancelling appointment with ID={}", id);
        appointmentRepository.save(appointment);
    }

    @Transactional
    private void validateAvailability(AppointmentDTO appointmentDTO) {
        LocalDateTime start = appointmentDTO.getAppointmentDateTime().minusMinutes(30);
        LocalDateTime end = appointmentDTO.getAppointmentDateTime().plusMinutes(30);

        List<Appointment> conflictingAppointments = appointmentRepository
                .findByDoctorIdAndAppointmentDateTimeBetween(appointmentDTO.getDoctorId(), start, end);

        if (!conflictingAppointments.isEmpty()) {
            throw new SchedulingConflictException("Doctor is unavailable for the selected time slot.");
        }
    }
}
