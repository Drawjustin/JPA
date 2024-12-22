package org.example.chapter08.correctv1.domain;//package org.example.chapter07.correctv1.domain;//package org.example.chapter05.correctv1.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
public abstract class Item08Cv1 extends BaseEntity08cv1 {
    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;

    private Integer price;

    private Integer stockquantity;


    @ManyToMany(mappedBy = "items")
    private List<Category08Cv1> categorys = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStockquantity() {
        return stockquantity;
    }

    public void setStockquantity(Integer stockquantity) {
        this.stockquantity = stockquantity;
    }

    public List<Category08Cv1> getCategorys() {
        return categorys;
    }

    public void setCategorys(List<Category08Cv1> categorys) {
        this.categorys = categorys;
    }
}


