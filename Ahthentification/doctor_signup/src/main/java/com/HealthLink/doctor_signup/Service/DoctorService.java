package com.HealthLink.doctor_signup.Service;


import com.HealthLink.doctor_signup.DTO.DoctorRegistrationDTO;
import com.HealthLink.doctor_signup.Entity.DoctorRegistration;
import com.HealthLink.doctor_signup.Repo.DoctorRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final PasswordEncoder passwordEncoder;

    public DoctorService(DoctorRepository doctorRepository, PasswordEncoder passwordEncoder) {
        this.doctorRepository = doctorRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public DoctorRegistration registerDoctor(DoctorRegistrationDTO doctorDTO) {
        DoctorRegistration doctor = new DoctorRegistration();
        doctor.setFirstName(doctorDTO.getFirstName());
        doctor.setLastName(doctorDTO.getLastName());
        doctor.setEmail(doctorDTO.getEmail());
        doctor.setPassword(passwordEncoder.encode(doctorDTO.getPassword()));
        doctor.setCity(doctorDTO.getCity());
        doctor.setCountry(doctorDTO.getCountry());
        doctor.setSpecialty(doctorDTO.getSpecialty());
        doctor.setAddress(doctorDTO.getAddress());
        doctor.setPhoneNumber(doctorDTO.getPhoneNumber());
        doctor.setOfficePhoneNumber(doctorDTO.getOfficePhoneNumber());
        doctor.setCertified(doctorDTO.isCertified());

        return doctorRepository.save(doctor);
    }

}
