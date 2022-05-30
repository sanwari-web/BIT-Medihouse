package com.bit.mediHouse.Models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name ="user")
@Data
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Integer id;

    @Column(name = "NIC")
   private String nic;

    @Column(name = "Email")
    private String email;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "First_name")
    private String first_name;

    @Column(name = "Last_name")
    private String last_name;

    @Column(name = "Role")
    private String role;

    @Column(name = "city")
    private String city;

    @Column(name = "district")
    private String district;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "dob")
    private String dob;

//
//    @Column(name = "image")
//    private String image;

    @Column(name = "Password")
    private String password;

//    private Integer sessionCount;

    public User() {}

    public User(String first_name, String email,String nic,String city,String district,String mobile,String dob, String gender,String last_name,String image, String role, Integer sessionCount, String password) {
        this.first_name = first_name;
        this.email = email;
        this.last_name = last_name;
        this.nic = nic;
        this.gender = gender;
        this.role = role;
        this.city = city;
        this.district = district;
        this.mobile = mobile;
        this.dob = dob;
      //  this.image = image;
       // this.sessionCount = sessionCount;
       this.password = password;
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
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", email='" + email + '\'' +
                ", last_name='" + last_name + '\'' +
                ", nic='" + nic + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
//                ", image='" + image + '\'' +
//                ", sessionCount='" + sessionCount + '\'' +
                ", role='" + role + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", mobile='" + mobile + '\'' +
                ", dob='" + dob + '\'' +

                '}';
    }

}
