package com.bit.mediHouse.Repository;

import com.bit.mediHouse.Models.Patient;
import com.bit.mediHouse.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient,Integer> {

    Patient getById(Integer id);

    void deletePatientById(Integer id);

    Optional<Patient>  findPatientById(Integer id);

    Optional<Patient> findPatientBynic(String nic);

    Optional<Patient> findPatientsBygender(String gender);

    Patient findByEmail(String email);


}
