package com.innovation.rentcloud.model.vehicle;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-19 03:39 pm Sunday
 **/

@Entity
@Table(name = "vehicle")
@Data
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String make;
    private String model;
    private String type;
    private int year;
    private int odometerValueOnRegister;
    private String color;
}
