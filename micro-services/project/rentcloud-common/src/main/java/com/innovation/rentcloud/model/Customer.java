package com.innovation.rentcloud.model;

import javax.persistence.*;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-18 09:26 PM Saturday
 **/
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String dlNumber;
    private String zipCode;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String dlNumber, String zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dlNumber = dlNumber;
        this.zipCode = zipCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDlNumber() {
        return dlNumber;
    }

    public void setDlNumber(String dlNumber) {
        this.dlNumber = dlNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
