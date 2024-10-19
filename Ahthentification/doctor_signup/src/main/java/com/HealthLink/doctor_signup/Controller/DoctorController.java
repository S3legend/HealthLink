package com.HealthLink.doctor_signup.Controller;

import com.HealthLink.doctor_signup.DTO.DoctorRegistrationDTO;
import com.HealthLink.doctor_signup.Entity.DoctorRegistration;
import com.HealthLink.doctor_signup.Service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping("/register")
    public ResponseEntity<DoctorRegistration> registerDoctor(@RequestBody DoctorRegistrationDTO doctorDTO) {
        DoctorRegistration registeredDoctor = doctorService.registerDoctor(doctorDTO);
        return ResponseEntity.ok(registeredDoctor);
    }
}
