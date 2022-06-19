package com.innovation.rentcloud.model.rent;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-19 03:38 pm Sunday
 **/

@Entity
@Table(name = "rent")
@Data
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rentId;
    private int customerId;
    private int vehicleId;
    private LocalDateTime rentFrom;
    private LocalDateTime rentTill;
    private int currentOdometer;
    private String returnLocation;
}
