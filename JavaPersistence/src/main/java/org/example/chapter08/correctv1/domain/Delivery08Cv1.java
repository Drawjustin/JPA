package org.example.chapter08.correctv1.domain;//package org.example.chapter07.correctv1.domain;//package org.example.chapter05.correctv1.domain;

import jakarta.persistence.*;

@Entity
public class Delivery08Cv1 extends BaseEntity08cv1 {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @Embedded
    private Address08Cv1 address;
    @Enumerated(EnumType.STRING)
    private Status status;

}
