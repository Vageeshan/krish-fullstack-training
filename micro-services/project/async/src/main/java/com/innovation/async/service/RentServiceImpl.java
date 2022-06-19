package com.innovation.async.service;

import org.springframework.stereotype.Service;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-19 10:13 am Sunday
 **/
@Service
public class RentServiceImpl implements RentProcessService{
    @Override
    public boolean validateDL(String dlNumber){
        return dlNumber.length() > 5;
    }
}
