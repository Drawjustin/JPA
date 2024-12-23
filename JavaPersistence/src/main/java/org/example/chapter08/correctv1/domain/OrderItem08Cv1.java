//package org.example.chapter08.correctv1.domain;//package org.example.chapter07.correctv1.domain;//package org.example.chapter05.correctv1.domain;
//
//import jakarta.persistence.*;
//
//@Entity
//public class OrderItem08Cv1 extends BaseEntity08cv1 {
//    @Id @GeneratedValue
//    @Column(name = "order_item_id")
//    private Long id;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "order_id")
//    private Orders08Cv1 order;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "item_id")
//    private Item08Cv1 item;
//
//    private Integer orderprice;
//
//    private Integer count;
//
//
//
//
//}
