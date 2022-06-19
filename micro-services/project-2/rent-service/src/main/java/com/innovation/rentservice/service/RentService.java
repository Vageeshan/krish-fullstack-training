package com.innovation.rentservice.service;

import com.innovation.rentcloud.model.rent.Rent;

import java.util.List;
import java.util.Map;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-19 04:11 pm Sunday
 **/
public interface RentService {
    Rent save(Rent rent);

    Rent findById(int id);

    List<Rent> findAll();

    Map<?,?> findDetailedResponse(int id);
}
