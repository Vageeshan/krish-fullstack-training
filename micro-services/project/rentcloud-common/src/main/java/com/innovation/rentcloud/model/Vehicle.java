package com.innovation.rentcloud.model;

import javax.persistence.*;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-18 09:26 PM Saturday
 **/
@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String make;
    private String model;
    private String type;
    private int year;

    public Vehicle() {
    }

    public Vehicle(String make, String model, String type, int year) {
        this.make = make;
        this.model = model;
        this.type = type;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
