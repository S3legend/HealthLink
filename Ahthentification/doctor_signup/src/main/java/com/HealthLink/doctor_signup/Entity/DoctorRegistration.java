package com.HealthLink.doctor_signup.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "doctors")
public class DoctorRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String city;
    private String country;
    private String specialty;
    private String address;
    private String phoneNumber;
    private String officePhoneNumber;

    @Column(columnDefinition = "boolean default true")
    private boolean isCertified;
}
