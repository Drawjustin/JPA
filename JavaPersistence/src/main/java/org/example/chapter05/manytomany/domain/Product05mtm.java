//package org.example.chapter05.manytomany.domain;
//
//import jakarta.persistence.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//public class Product05mtm {
//    @Id @GeneratedValue
//    @Column(name = "PRODUCT_ID")
//    private Long id;
//
//    private String name;
//
//    @OneToMany(mappedBy = "product")
//    private List<MemberProduct05mtm> memberProducts = new ArrayList<>();
////    @ManyToMany(mappedBy = "products")
////    private List<Member05mtm> members = new ArrayList<>();
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//}
