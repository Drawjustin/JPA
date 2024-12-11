package org.example.chapter05.correctv1.domain;

import jakarta.persistence.*;

@Entity
public class Delivery05cv1 {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private CityState city;

    private String street;

    private String zipcode;

    @Enumerated(EnumType.STRING)
    private Status status;

}
