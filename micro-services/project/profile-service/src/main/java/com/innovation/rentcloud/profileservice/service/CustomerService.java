package com.innovation.rentcloud.profileservice.service;

import com.innovation.rentcloud.model.Customer;

import java.util.List;
import java.util.Optional;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-18 01:40 pm Saturday
 **/
public interface CustomerService {
    Customer save(Customer customer);

    List<Customer> fetchAll();

    Optional<Customer> fetchOneById(int id);
}
