//package org.example.chapter06.correctv1.domain;//package org.example.chapter05.correctv1.domain;
//
//import jakarta.persistence.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn
//public abstract class Item06cv1 extends BaseEntity06cv1{
//    @Id @GeneratedValue
//    @Column(name = "item_id")
//    private Long id;
//
//    private String name;
//
//    private Integer price;
//
//    private Integer stockquantity;
//
//
//    @ManyToMany(mappedBy = "items")
//    private List<Category06cv1> categorys = new ArrayList<>();
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
//    public Integer getPrice() {
//        return price;
//    }
//
//    public void setPrice(Integer price) {
//        this.price = price;
//    }
//
//    public Integer getStockquantity() {
//        return stockquantity;
//    }
//
//    public void setStockquantity(Integer stockquantity) {
//        this.stockquantity = stockquantity;
//    }
//
//    public List<Category06cv1> getCategorys() {
//        return categorys;
//    }
//
//    public void setCategorys(List<Category06cv1> categorys) {
//        this.categorys = categorys;
//    }
//}
//
//
