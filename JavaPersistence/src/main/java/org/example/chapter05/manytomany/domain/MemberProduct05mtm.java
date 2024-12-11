//package org.example.chapter05.manytomany.domain;
//
//import jakarta.persistence.*;
//
//import java.time.LocalDateTime;
//
//@Entity
//public class MemberProduct05mtm {
//    @Id @GeneratedValue
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "MEMBER_ID")
//    private Member05mtm member;
//
//    @ManyToOne
//    @JoinColumn(name = "PRODUCT_ID")
//    private Product05mtm product;
//
//
//    private int count;
//    private int price;
//
//    private LocalDateTime orderDateTime;
//
//
//}
