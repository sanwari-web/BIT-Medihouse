package com.bit.mediHouse.Models;

import javax.persistence.*;
import java.util.Date;

@Entity(name ="pricing")
@Table(name = "Pricing")
public class Pricing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Integer pricing_id;

    @ManyToOne(optional = false, targetEntity = User.class)
    @JoinColumn(name = "patien_id", nullable = false)
    private User patient;

    @ManyToOne( optional = false, targetEntity = User.class)
    @JoinColumn(name = "consulta_id", nullable = false)
    private User user;

    @OneToOne( optional = false, targetEntity = Session.class)
    @JoinColumn(name = "sessions_id", nullable = false)

    private Session session;

    @Column(name = "consultation_fees")
    private String consultation_fees;

    @Column(name = "medication_fees")
    private String medication_fees;

    @Column(name = "total_bill")
    private Integer total_bill;

    @Temporal(TemporalType.DATE)
    @Column(name = "date", nullable = false)
    private Date date;

    @PrePersist
    private  void onCreate(){
        date = new Date();
    }
    public Pricing() {}

    public Pricing(String consultation_fees,User patient,Date date,User user,Session session, String medication_fees, Integer total_bill ) {
        this.medication_fees = medication_fees;
        this.consultation_fees = consultation_fees;
        this.total_bill = total_bill;
        this.patient  =  patient;
        this.date = date;
        this.user  =  user;
        this.session = session;

    }

    public Integer getPricing_id() {
        return pricing_id;
    }

    public void setPricing_id(Integer pricing_id) {
        this.pricing_id = pricing_id;
    }

    public String getConsultation_fees() {
        return consultation_fees;
    }

    public void setConsultation_fees(String consultation_fees) {
        this.consultation_fees = consultation_fees;
    }

    public String getMedication_fees() {
        return medication_fees;
    }

    public void setMedication_fees(String medication_fees) {
        this.medication_fees = medication_fees;
    }

    public Integer getTotal_bill() {
        return total_bill;
    }

    public void setTotal_bill(Integer total_bill) {
        this.total_bill = total_bill;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
    public Session getSession() {
        return session;
    }

    public void setSession(Session sesssion) {
        this.session = sesssion;
    }

    @Override
    public String toString() {
        return "Employee{" +
                ", consultation_fees='" + consultation_fees + '\'' +
                ", medication_fees='" + medication_fees + '\'' +
                ", total_bill='" + total_bill + '\'' +
                ", user ='" + user + '\'' +
                ", patient='" + patient + '\'' +
                ", session ='" + session + '\'' +
                ", date ='" + date + '\'' +
                '}';
    }

}
