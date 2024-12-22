//package org.example.chapter07.correctv1.domain;//package org.example.chapter05.correctv1.domain;
//
//import jakarta.persistence.*;
//
//import java.time.LocalDateTime;
//
//@Entity
//public class Orders07Cv1 extends BaseEntity07cv1 {
//    @Id @GeneratedValue
//    @Column(name = "order_id")
//    private Long id;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "member_id")
//    private Member07Cv1 member;
//
//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "delivery_id")
//    private Delivery07Cv1 delivery;
//
//    private LocalDateTime orderdate;
//
//    @Enumerated(EnumType.STRING)
//    private Status status;
//
//
//
//}
