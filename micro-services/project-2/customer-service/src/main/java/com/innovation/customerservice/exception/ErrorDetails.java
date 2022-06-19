package com.innovation.customerservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-19 03:50 pm Sunday
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;
}
