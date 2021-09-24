package com.BankSystem;

import java.sql.Date;

public class User
{
    private int accountNo;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String PAN;
    private String aadhar;
    private String address;
    private Date DOB;
    private String gender;
    private double balance;
    private String password;


    public User(){}

    public User(User other) {
        this.accountNo = other.accountNo;
        this.firstName = other.firstName;
        this.lastName = other.lastName;
        this.email = other.email;
        this.mobile = other.mobile;
        this.PAN = other.PAN;
        this.aadhar = other.aadhar;
        this.address = other.address;
        this.DOB = other.DOB;
        this.gender = other.gender;
        this.balance = other.balance;
        this.password = other.password;
    }

    public String toString() {
        return "User{" +
                "accountNo=" + accountNo +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", PAN='" + PAN + '\'' +
                ", aadhar='" + aadhar + '\'' +
                ", address='" + address + '\'' +
                ", DOB=" + DOB +
                ", gender='" + gender + '\'' +
                ", balance=" + balance +
                ", password='" + password + '\'' +
                '}';
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPAN() {
        return PAN;
    }

    public void setPAN(String PAN) {
        this.PAN = PAN;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
