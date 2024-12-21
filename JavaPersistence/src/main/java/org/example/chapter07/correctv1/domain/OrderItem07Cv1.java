package org.example.chapter07.correctv1.domain;//package org.example.chapter05.correctv1.domain;

import jakarta.persistence.*;

@Entity
public class OrderItem07Cv1 extends BaseEntity07cv1 {
    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Orders07Cv1 order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item07Cv1 item;

    private Integer orderprice;

    private Integer count;




}
