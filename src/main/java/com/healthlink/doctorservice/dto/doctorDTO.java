package com.healthlink.doctorservice.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;

@Data
public class doctorDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String country;
    private String doctorPassword;
    private int age;
    private String specialization;
    private LocalTime startTimeOfWork;

    private LocalTime endTimeOfWork;
    private String biography;
}