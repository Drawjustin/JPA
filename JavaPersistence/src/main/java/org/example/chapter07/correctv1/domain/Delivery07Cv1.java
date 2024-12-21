package org.example.chapter07.correctv1.domain;//package org.example.chapter05.correctv1.domain;

import jakarta.persistence.*;

@Entity
public class Delivery07Cv1 extends BaseEntity07cv1 {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private CityState07cv1 city;

    private String street;

    private String zipcode;

    @Enumerated(EnumType.STRING)
    private Status status;

}
