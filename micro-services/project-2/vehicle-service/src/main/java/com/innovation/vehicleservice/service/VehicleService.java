package com.innovation.vehicleservice.service;

import com.innovation.rentcloud.model.vehicle.Vehicle;

import java.util.List;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-19 04:02 pm Sunday
 **/
public interface VehicleService {
    List<Vehicle> findAll();
    Vehicle findById(int id);
    Vehicle save(Vehicle vehicle);
}
