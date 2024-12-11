package org.example.chapter05.correctv1.domain;

import jakarta.persistence.*;

@Entity
public class OrderItem05cv1 {
    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders05cv1 order;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item05cv1 item;

    private Integer orderprice;

    private Integer count;




}
