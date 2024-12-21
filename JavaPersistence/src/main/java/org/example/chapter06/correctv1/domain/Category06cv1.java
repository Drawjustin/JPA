package org.example.chapter06.correctv1.domain;//package org.example.chapter05.correctv1.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Category06cv1 extends BaseEntity06cv1{
    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category06cv1 parent;

    @OneToMany(mappedBy = "parent")
    private List<Category06cv1> child = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "category_item",
    joinColumns = @JoinColumn(name = "category_id"),
    inverseJoinColumns = @JoinColumn(name="item_id"))
    private List<Item06cv1> items = new ArrayList<>();



    private String name;
}
