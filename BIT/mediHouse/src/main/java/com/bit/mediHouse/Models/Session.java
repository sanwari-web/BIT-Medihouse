package com.bit.mediHouse.Models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Session")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Integer session_id;

    @Column(name = "reason")
    private String reason;

    @Column(name = "diagnosis")
    private String diagnosis;

    @Column(name = "diagnosis_details")
    private String diagnosis_details;

    @Column(name = "clinic_medicine")
    private String clinic_medicine;

    @Column(name = "pharmacy_medicine")
    private String pharmacy_medicine;

    @Column(name = "medical_operations")
    private String medical_operations;


    @Column(name = "medical_reports")
    private String medical_reports;

   @Temporal(TemporalType.DATE)
//    @JsonFormat(pattern="EEEE, MMMM d, y")
    @Column(name = "date", nullable = false)
    private Date date;

    @PrePersist
    private  void onCreate(){
        date = new Date();
    }

    @ManyToOne(optional = false, targetEntity = User.class)
    @JoinColumn(name = "patient_id", nullable = false)
    private User patient;

    @ManyToOne( optional = false, targetEntity = User.class)
    @JoinColumn(name = "consult_id", nullable = false)
    private User user;

    public Session(Integer session_id,User patient,User user,Date date,String reason , String diagnosis, String diagnosis_details,String clinic_medicine,String pharmacy_medicine, String medical_operations, String medical_reports ) {

           this.session_id = session_id;
            this.patient  =  patient;
            this.user  =  user;
            this.reason = reason;
            this.date = date;
            this.diagnosis = diagnosis;
            this.diagnosis_details = diagnosis_details;
            this.clinic_medicine = clinic_medicine;
            this.pharmacy_medicine = pharmacy_medicine;
            this.medical_operations = medical_operations;
            this.medical_reports = medical_reports;

    }

    public Session() {

    }


    public Integer getSession_id() {
        return session_id;
    }

    public void setSession_id(Integer session_id) {
        this.session_id = session_id;
    }

    public User  getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getPatient() {
        return patient;
    }

    public void setPatient(User patient) {
        this.patient = patient;
    }

    public String getreason() {
        return reason;
    }

    public void setreason(String reason) {
        this.reason = reason;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getDiagnosis_details() {
        return diagnosis_details;
    }

    public void setDiagnosis_details(String diagnosis_details) {
        this.diagnosis_details = diagnosis_details;
    }

    public String getClinic_medicine() {
        return clinic_medicine;
    }

    public void setClinic_medicine(String clinic_medicine) {
        this.clinic_medicine = clinic_medicine;
    }

    public String getPharmacy_medicine() {
        return pharmacy_medicine;
    }

    public void setPharmacy_medicine(String pharmacy_medicine) {
        this.pharmacy_medicine = pharmacy_medicine;
    }

    public String getMedical_operations() {
        return medical_operations;
    }

    public void setMedical_operations(String medical_operations) {
        this.medical_operations = medical_operations;
    }

    public String getMedical_reports() {
        return medical_reports;
    }

    public void setMedical_reports(String medical_reports) {
        this.medical_reports = medical_reports;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "Session{" +
                "session_id=" + session_id +
                ", user ='" + user + '\'' +
                ", patient='" + patient + '\'' +
                ", reason='" + reason + '\'' +
                ", date='" + date + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", diagnosis_details='" + diagnosis_details + '\'' +
                ", medical_reports='" + medical_reports + '\'' +
                ", medical_operations='" + medical_operations + '\'' +
                ", clinic_medicine='" + clinic_medicine + '\'' +
                '}';
    }}



