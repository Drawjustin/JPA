//package org.example.chapter06.correctv1.domain;//package org.example.chapter05.correctv1.domain;
//
//import jakarta.persistence.*;
//
//import java.time.LocalDateTime;
//
//@Entity
//public class Orders06cv1 extends BaseEntity06cv1{
//    @Id @GeneratedValue
//    @Column(name = "order_id")
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "member_id")
//    private Member06cv1 member;
//
//    @OneToOne
//    @JoinColumn(name = "delivery_id")
//    private Delivery06cv1 delivery;
//
//    private LocalDateTime orderdate;
//
//    @Enumerated(EnumType.STRING)
//    private Status status;
//
//
//
//}
