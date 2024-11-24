package com.healthlink.patientservice.dto;

import lombok.Data;

@Data
public class PatientDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String country;
}