package com.innovation.customerservice.service;

import com.innovation.rentcloud.model.customer.Customer;

import java.util.List;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-19 03:42 pm Sunday
 **/
public interface CustomerService {
    Customer save(Customer customer);

    Customer findById(int id);

    List<Customer> findAll();
}
