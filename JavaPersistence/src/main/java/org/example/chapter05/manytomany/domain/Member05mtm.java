//package org.example.chapter05.manytomany.domain;
//
//import jakarta.persistence.*;
//import org.example.chapter05.onetoone.domain.Locker05oto;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//public class Member05mtm {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "MEMBER_ID")
//    private Long id;
//
//    private String name;
//
//    private String city;
//
//    private String street;
//
//    private String zipcode;
//
//    @OneToOne
//    @JoinColumn(name = "LOCKER_ID")
//    private Locker05oto locker;
//
//    @OneToMany(mappedBy = "member")
//    private List<MemberProduct05mtm> memberProducts = new ArrayList<>();
////    @ManyToMany
////    @JoinTable(name = "MEMBER_PRODUCT")
////    private List<Product05mtm> products = new ArrayList<>();
//
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
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public String getStreet() {
//        return street;
//    }
//
//    public void setStreet(String street) {
//        this.street = street;
//    }
//
//    public String getZipcode() {
//        return zipcode;
//    }
//
//    public void setZipcode(String zipcode) {
//        this.zipcode = zipcode;
//    }
//
//
//}
