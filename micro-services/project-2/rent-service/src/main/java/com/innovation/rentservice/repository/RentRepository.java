package com.innovation.rentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.innovation.rentcloud.model.rent.Rent;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-19 04:10 pm Sunday
 **/
public interface RentRepository extends JpaRepository<Rent, Integer> {
}
