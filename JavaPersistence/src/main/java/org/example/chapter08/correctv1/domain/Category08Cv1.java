package org.example.chapter08.correctv1.domain;//package org.example.chapter07.correctv1.domain;//package org.example.chapter05.correctv1.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.*;

@Entity
public class Category08Cv1 extends BaseEntity08cv1 {
    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "parent_id")
    private Category08Cv1 parent;

    @OneToMany(mappedBy = "parent")
    private List<Category08Cv1> child = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "category_item",
    joinColumns = @JoinColumn(name = "category_id"),
    inverseJoinColumns = @JoinColumn(name="item_id"))
    private List<Item08Cv1> items = new ArrayList<>();



    private String name;
}
