package com.healthlink.doctorservice.repository;

import com.healthlink.doctorservice.entity.doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface doctorRepository extends JpaRepository<doctor, Long> {
}
