package com.innovation.customerservice.repository;

import com.innovation.rentcloud.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-19 03:40 pm Sunday
 **/
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
