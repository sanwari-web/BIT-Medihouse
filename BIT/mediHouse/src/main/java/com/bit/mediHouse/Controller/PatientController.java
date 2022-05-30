package com.bit.mediHouse.Controller;


import com.bit.mediHouse.Models.Patient;
import com.bit.mediHouse.Models.User;
import com.bit.mediHouse.Services.PatientService;
import com.bit.mediHouse.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class PatientController {

    @Autowired
    private PatientService patientService;

    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }



    @GetMapping("/patient/find")
    public ResponseEntity<List<Patient>> getAllPatient() {
        List<Patient> patient = patientService.findAllPatient();
        return new ResponseEntity <>(patient, HttpStatus.OK);
    }

    @GetMapping("/patient/find/{id}")
    public ResponseEntity <Patient> getPatientById(@PathVariable("id") Integer id){
        Patient patient = patientService.findPatientById(id);
        return new ResponseEntity <>(patient, HttpStatus.OK);
    }
    @GetMapping("/patient/find/nic/{nic}")
    public ResponseEntity <Patient> getPatientBynic(@PathVariable("nic") String nic) {
        Patient patient = patientService.findPatientBynic(nic);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @GetMapping("/patient/find/gender/{gender}")
        public ResponseEntity <Patient> getPatientBygender(@PathVariable("gender") String gender ){
            Patient patient = patientService.findPatientBygender(gender);
            return new ResponseEntity <>(patient, HttpStatus.OK);
    }
    @PostMapping("/patient/add")
    public ResponseEntity <Patient> addPatient(@RequestBody Patient patient){
        Patient newPatient = patientService.addPatient(patient);
        return new ResponseEntity <>(newPatient, HttpStatus.CREATED);
    }

    @PostMapping("/patient/update")
    public ResponseEntity <Patient> updatePatient(@RequestBody Patient patient){
        Patient updatePatient = patientService.updatePatient(patient);
        return new ResponseEntity <>(updatePatient, HttpStatus.CREATED);
    }

    @Transactional
    @DeleteMapping("/patient/delete/{id}")
    public ResponseEntity <?> deletePatient(@PathVariable("id") Integer id){
        patientService.deletePatient(id);
        return new ResponseEntity <>(HttpStatus.OK);
    }

}
