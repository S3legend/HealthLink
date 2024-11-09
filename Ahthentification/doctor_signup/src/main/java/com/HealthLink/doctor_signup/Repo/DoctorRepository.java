package com.HealthLink.doctor_signup.Repo;

import com.HealthLink.doctor_signup.Entity.DoctorRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorRegistration, Long> {

    public DoctorRegistration findByEmail(String email);
}
