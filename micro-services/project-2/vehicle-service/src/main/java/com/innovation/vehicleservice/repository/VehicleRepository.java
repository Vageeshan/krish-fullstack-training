package com.innovation.vehicleservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.innovation.rentcloud.model.vehicle.Vehicle;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-19 04:01 pm Sunday
 **/
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
}
