package com.innovation.vehicleservice.controller;

import com.innovation.rentcloud.model.vehicle.Vehicle;
import com.innovation.vehicleservice.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-19 04:04 pm Sunday
 **/

@RestController
@RequestMapping("/api/v1")
public class VehicleController {
    @Autowired
    VehicleService vehicleService;

    @GetMapping("/vehicle")
    public List<Vehicle> getAllVehicles() {
        return vehicleService.findAll();
    }

    @GetMapping(value = "/vehicle/{id}")
    public Vehicle getVehicle(@PathVariable int id) {
        return vehicleService.findById(id);
    }

    @PostMapping("/vehicle")
    public Vehicle save(@RequestBody Vehicle vehicle) {
        return vehicleService.save(vehicle);
    }
}
