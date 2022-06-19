package com.innovation.rentservice.service;

import com.innovation.rentcloud.model.customer.Customer;
import com.innovation.rentcloud.model.rent.Rent;
import com.innovation.rentcloud.model.vehicle.Vehicle;
import com.innovation.rentservice.exception.ResourceNotFoundException;
import com.innovation.rentservice.repository.RentRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-19 04:12 pm Sunday
 **/

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private RentRepository rentRepository;

    @Autowired
    private RestTemplate restTemplate;

    private static final String CUSTOMER_BASE_URL = "http://customer/api/v1/customer";
    private static final String VEHICLE_BASE_URL = "http://vehicle/api/v1/vehicle";

    @Override
    public Rent save(Rent rent) {
        return rentRepository.save(rent);
    }

    @Override
    public Rent findById(int id) {
        return rentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Record not found"));
    }

    @Override
    public List<Rent> findAll() {
        return rentRepository.findAll();
    }

    @Override
    public Map<String, Object> findDetailedResponse(int id) {
        Rent rent = findById(id);
        Customer customer = getCustomerById(rent.getCustomerId());
        Vehicle vehicle = getVehicleById(rent.getVehicleId());
        Map<String, Object> response = new HashMap<>();
        response.put("rent", rent);
        response.put("customer", customer);
        response.put("vehicle", vehicle);
        return response;
    }

    private Customer getCustomerById(int id) {
        Customer customer = restTemplate.getForObject(CUSTOMER_BASE_URL + "/" + id, Customer.class);
        if (customer == null) {
            throw new ResourceNotFoundException("Record not found");
        }
        return customer;
    }

    private Vehicle getVehicleById(int id) {
        Vehicle vehicle = restTemplate.getForObject(VEHICLE_BASE_URL + "/" + id, Vehicle.class);
        if (vehicle == null) {
            throw new ResourceNotFoundException("Record not found");
        }
        return vehicle;
    }
}
