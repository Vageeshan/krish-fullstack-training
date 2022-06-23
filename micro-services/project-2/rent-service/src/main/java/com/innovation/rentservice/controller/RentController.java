package com.innovation.rentservice.controller;

import com.innovation.rentcloud.model.rent.Rent;
import com.innovation.rentservice.dto.CommonResponse;
import com.innovation.rentservice.service.RentService;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-19 04:13 pm Sunday
 **/

@RestController
@RequestMapping("/api/v1")
@Slf4j
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
    public ResponseEntity<CommonResponse<?>> getRentDetails(@PathVariable int id, @RequestParam(required = false) String type) {
        log.info("Hit " + attempt++ + " " + new Date());
        if (type == null) {
            return ResponseEntity.ok(new CommonResponse<>(rentService.findById(id)));
        } else if (type.equals("detailed")) {
            return ResponseEntity.ok(new CommonResponse<>(rentService.findDetailedResponse(id)));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CommonResponse<>("Invalid type"));
        }
    }

    private ResponseEntity<CommonResponse<?>> getRentDetailsFallBack(Exception exception) {
        return ResponseEntity.ok(new CommonResponse<>("Please try again later : " + (exception.getMessage())));
    }

    @PostMapping("/rent")
    public CommonResponse<?> save(@RequestBody Rent rent) {
        return new CommonResponse<>(rentService.save(rent));
    }
}
