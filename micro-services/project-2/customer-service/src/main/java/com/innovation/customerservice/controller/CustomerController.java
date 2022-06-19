package com.innovation.customerservice.controller;

import com.innovation.customerservice.service.CustomerService;
import com.innovation.rentcloud.model.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-19 03:40 pm Sunday
 **/

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer")
    public List<Customer> getAllCustomers() {
        return customerService.findAll();
    }

    @GetMapping(value = "/customer/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        return customerService.findById(id);
    }

    @PostMapping("/customer")
    public Customer save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }
}
