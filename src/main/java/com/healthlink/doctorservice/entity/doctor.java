package com.healthlink.doctorservice.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String address;

    @DateTimeFormat(pattern = "HH:mm:ss")
    @Column
    private LocalTime startTimeOfWork;

    @DateTimeFormat(pattern = "HH:mm:ss")
    @Column
    private LocalTime endTimeOfWork;

    @Lob
    private String biography;

    @Column
    private String doctorPassword;
    private int age;
    private String specialization;
    private String city;
    private String country;


}