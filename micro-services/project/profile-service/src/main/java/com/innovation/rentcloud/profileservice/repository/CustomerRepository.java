package com.innovation.rentcloud.profileservice.repository;

import com.innovation.rentcloud.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-18 01:38 pm Saturday
 **/
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
