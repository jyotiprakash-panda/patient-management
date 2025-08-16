package com.jyotiprakash.microservice.patientservice.repository;

import com.jyotiprakash.microservice.patientservice.model.Patient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {
    boolean existsByEmail(String email);
    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END " +
            "FROM Patient u " +
            "WHERE u.email = :email AND u.id <> :id")
    boolean existsByEmailAndIdNot(@Param("email") String email, @Param("id") UUID id);
    //boolean existsByEmailAndIdNot(@NotBlank(message = "Email is required") @Email(message = "Email should be valid") String email, UUID id);
}
