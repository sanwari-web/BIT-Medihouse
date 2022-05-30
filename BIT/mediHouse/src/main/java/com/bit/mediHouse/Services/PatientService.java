package com.bit.mediHouse.Services;

import com.bit.mediHouse.Models.Patient;
import com.bit.mediHouse.Models.User;
import com.bit.mediHouse.Repository.PatientRepository;
import com.bit.mediHouse.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
@Slf4j
public class PatientService {

    private final PatientRepository patientRepository;
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Patient patient = patientRepository.findByEmail(email);
//        if (patient== null){
//            log.error("User not found");
//            throw new UsernameNotFoundException("User not found");
//        }else {
//            log.info("User found :{}",email);
//
//        }
//        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
//
//
//        return new org.springframework.security.core.userdetails.User(patient.getEmail(),patient.getNic(),authorities);
//    }

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient addPatient(Patient patient) {
        // user.setId();
        return patientRepository.save(patient);
    }

    public List<Patient> findAllPatient() {
        return patientRepository.findAll();
    }

    public Patient updatePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient findPatientById(Integer id) {
        return patientRepository.findPatientById(id).orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }
    public Patient findPatientBynic(String nic) {
        return patientRepository.findPatientBynic(nic).orElseThrow(() -> new UserNotFoundException("User by nic " + nic + " was not found"));
    }
    public Patient findPatientBygender(String gender) {
        return patientRepository.findPatientsBygender(gender).orElseThrow(() -> new UserNotFoundException("User by nic " + gender + " was not found"));
    }

    public void deletePatient(Integer id){
        patientRepository.deletePatientById(id);
    }

}
