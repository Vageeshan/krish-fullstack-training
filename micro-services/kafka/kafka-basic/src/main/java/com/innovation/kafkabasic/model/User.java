package com.innovation.kafkabasic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-26 01:03 AM Sunday
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int id;
    private String name;
    private String email;
    private String[] languages;
}
