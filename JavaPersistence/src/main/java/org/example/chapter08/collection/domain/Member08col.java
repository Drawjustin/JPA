package org.example.chapter08.collection.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Member08col {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    private String username;

    @Embedded
    private Period06col period06col;

    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOOD", joinColumns =
    @JoinColumn(name = "MEMBER_ID"))
    @Column(name = "FOOD_NAME")
    private Set<String> favoriteFoods = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "PERIOD", joinColumns =
    @JoinColumn(name = "MEMBER_ID"))
    private List<Period06col> periodHistory = new ArrayList<>();

    public Period06col getPeriod06col() {
        return period06col;
    }

    public Set<String> getFavoriteFoods() {
        return favoriteFoods;
    }

    public void setFavoriteFoods(Set<String> favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
    }

    public List<Period06col> getPeriodHistory() {
        return periodHistory;
    }

    public void setPeriod06col(Period06col period06col) {
        this.period06col = period06col;
    }

    public void setPeriodHistory(List<Period06col> periodHistory) {
        this.periodHistory = periodHistory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Period06col getPeriod() {
        return period06col;
    }

    public void setPeriod(Period06col period06col) {
        this.period06col = period06col;
    }
}
