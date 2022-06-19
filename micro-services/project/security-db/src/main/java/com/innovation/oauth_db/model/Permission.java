package com.innovation.oauth_db.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-17 06:35 pm Saturday
 **/

@Entity
@Table(name = "permission")
@Data
public class Permission implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "name")
    private String name;
}
