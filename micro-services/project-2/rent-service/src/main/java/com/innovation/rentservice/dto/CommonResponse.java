package com.innovation.rentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-19 04:12 pm Sunday
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse<T> {
    T data;
}
