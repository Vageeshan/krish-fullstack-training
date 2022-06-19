package com.innovation.rentcloud.profileservice.service;

import com.innovation.rentcloud.model.Customer;
import com.innovation.rentcloud.profileservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-18 01:40 pm Saturday
 **/

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> fetchAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> fetchOneById(int id) {
        return customerRepository.findById(id);
    }
}
