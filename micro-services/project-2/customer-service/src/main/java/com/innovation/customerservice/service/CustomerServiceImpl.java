package com.innovation.customerservice.service;

import com.innovation.customerservice.exception.ResourceNotFoundException;
import com.innovation.customerservice.repository.CustomerRepository;
import com.innovation.rentcloud.model.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-19 03:45 pm Sunday
 **/

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Record not found"));
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
