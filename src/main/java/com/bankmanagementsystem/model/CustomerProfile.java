package com.bankmanagementsystem.model;

import java.time.LocalDate;

public class CustomerProfile {
    private String customerId;
    private String fullName;
    private String address;
    private String phoneNo;
    private String email;
    private LocalDate dob;

    public CustomerProfile(String customerId, String fullName, String address, String phoneNo, String email, LocalDate dob) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.address = address;
        this.phoneNo = phoneNo;
        this.email = email;
        this.dob = dob;
    }

    // Getters and setters
    public String getCustomerId() { return customerId; }
    public String getFullName() { return fullName; }
    public String getAddress() { return address; }
    public String getPhoneNo() { return phoneNo; }
    public String getEmail() { return email; }
    public LocalDate getDob() { return dob; }

    public void setCustomerId(String customerId) { this.customerId = customerId; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setAddress(String address) { this.address = address; }
    public void setPhoneNo(String phoneNo) { this.phoneNo = phoneNo; }
    public void setEmail(String email) { this.email = email; }
    public void setDob(LocalDate dob) { this.dob = dob; }
}
