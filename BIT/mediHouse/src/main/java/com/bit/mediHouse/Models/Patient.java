package com.bit.mediHouse.Models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Integer id;

//    @OneToMany(mappedBy = "patient")
//    private List<Sesssion> sesssions;

    @Column(name = "nic")
    private String nic;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "gender")
    private String gender;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "city")
    private String city;

    @Column(name = "district")
    private String district;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "dob")
    private String dob;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "patient_id", referencedColumnName = "id")
//    private List<Sesssion> sesssion;

//    public Patient() {}

    public Patient(String firstname, String password, String email,String nic, String gender,String lastname,String dob, String city, String district, String mobile) {
        this.firstname = firstname;
        this.email = email;
        this.nic = nic;
        this.gender = gender;
        this.password = password;
        this.lastname = lastname;
        this.city = city;
        this.district = district;
        this.mobile = mobile;
        this.dob = dob;

    }

    public Patient() {

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email  = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", email='" + email + '\'' +
                ", lastname='" + lastname + '\'' +
                ", nic='" + nic + '\'' +
                ", gender='" + gender + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }


}
