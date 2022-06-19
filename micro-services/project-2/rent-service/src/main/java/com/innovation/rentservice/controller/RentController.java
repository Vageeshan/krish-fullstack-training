package com.innovation.rentservice.controller;

import com.innovation.rentcloud.model.customer.Customer;
import com.innovation.rentcloud.model.rent.Rent;
import com.innovation.rentservice.dto.CommonResponse;
import com.innovation.rentservice.service.RentService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-19 04:13 pm Sunday
 **/

@RestController
@RequestMapping("/api/v1")
public class RentController {

    private static final String CUSTOMER_SERVICE = "customerService";
    private int attempt = 1;

    @Autowired
    private RentService rentService;

    @GetMapping("/rent")
    public CommonResponse<?> getAllRents() {
        return new CommonResponse<>(rentService.findAll());
    }

    @GetMapping(value = "/rent/{id}")
//    @CircuitBreaker(name = CUSTOMER_SERVICE, fallbackMethod = "getRentDetailsFallBack")
    @Retry(name = CUSTOMER_SERVICE, fallbackMethod = "getRentDetailsFallBack")
    public CommonResponse<?> getRentDetails(@PathVariable int id, @RequestParam(required = false) String type) {
        if (type == null) {
            return new CommonResponse<>(rentService.findById(id));
        } else {
            System.out.println("Hit "+attempt++ +" "+new Date());
            return new CommonResponse<>(rentService.findDetailedResponse(id));
        }
    }

    private CommonResponse<?> getRentDetailsFallBack(Exception exception) {
        return new CommonResponse<>("Please try again later");
    }

    @PostMapping("/rent")
    public CommonResponse<?> save(@RequestBody Rent rent) {
        return new CommonResponse<>(rentService.save(rent));
    }
}
