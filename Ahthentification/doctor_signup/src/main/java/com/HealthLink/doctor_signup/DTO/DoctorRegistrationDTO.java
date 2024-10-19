package com.HealthLink.doctor_signup.DTO;

import lombok.Data;

@Data
public class DoctorRegistrationDTO {
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
    private boolean isCertified;

}
