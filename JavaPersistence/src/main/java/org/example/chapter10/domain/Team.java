package org.example.chapter10.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {
    @Id @GeneratedValue
    private Long id;
    private String username;
    private int age;

    public List<Member> getList() {
        return list;
    }

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    private List<Member> list = new ArrayList<>();
public List<Member> getMembers(){
    return list;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
