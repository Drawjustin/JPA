package org.example.chapter05.correctv1.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Item05cv1 {
    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;

    private Integer price;

    private Integer stockquantity;


    @ManyToMany(mappedBy = "items")
    private List<Category05cv1> categorys = new ArrayList<>();

}


