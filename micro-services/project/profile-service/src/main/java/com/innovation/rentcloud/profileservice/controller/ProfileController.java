package com.innovation.rentcloud.profileservice.controller;

import com.innovation.rentcloud.model.Customer;
import com.innovation.rentcloud.profileservice.exception.ResourceNotFoundException;
import com.innovation.rentcloud.profileservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-18 01:36 pm Saturday
 **/

@RestController
@RequestMapping("/api/v1")
public class ProfileController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
//     @PreAuthorize("hasRole('ROLE_OPERATOR')")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Customer> getAll() {
        return customerService.fetchAll();
    }

    @PostMapping("/customers")
    @PreAuthorize("hasAuthority('create_profile')")
    public Customer save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @GetMapping("/customers/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EDITOR')")
    public Customer getOne(@PathVariable int id) {
        return customerService.fetchOneById(id).orElseThrow(() -> new ResourceNotFoundException("Record not found"));
    }
}
