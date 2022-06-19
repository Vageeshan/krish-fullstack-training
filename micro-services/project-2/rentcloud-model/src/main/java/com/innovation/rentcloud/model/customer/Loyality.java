package com.innovation.rentcloud.model.customer;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-19 03:36 pm Sunday
 **/

@Entity
@Table(name = "loyalityPoint")
@Data
public class Loyality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;
    @ManyToOne
    @JoinColumn
    private Customer customer;
    private int point;
    private LocalDateTime expireDate;
}
