package com.innovation.vehicleservice.service;

import com.innovation.rentcloud.model.vehicle.Vehicle;
import com.innovation.vehicleservice.exception.ResourceNotFoundException;
import com.innovation.vehicleservice.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-19 04:02 pm Sunday
 **/
@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle findById(int id) {
        return vehicleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Record not found"));
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }
}
