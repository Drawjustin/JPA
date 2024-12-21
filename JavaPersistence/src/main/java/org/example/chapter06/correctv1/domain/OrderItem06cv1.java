package org.example.chapter06.correctv1.domain;//package org.example.chapter05.correctv1.domain;

import jakarta.persistence.*;

@Entity
public class OrderItem06cv1 extends BaseEntity06cv1{
    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders06cv1 order;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item06cv1 item;

    private Integer orderprice;

    private Integer count;




}
