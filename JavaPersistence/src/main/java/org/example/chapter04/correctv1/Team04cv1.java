package org.example.chapter04.correctv1;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
public class Team04cv1 {
    @Id @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;
    @Column(name = "TEAM_NAME")
    private String name;
    @OneToMany(mappedBy = "team")
    private List<Member04cv1> members = new ArrayList<>();

    public List<Member04cv1> getMembers() {
        return members;
    }

//    public void addMember(Member04cv1 member04cv1){
//        member04cv1.setTeam(this);
//        members.add(member04cv1);
//    }
    public void setMembers(List<Member04cv1> members) {
        this.members = members;
    }

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

    @Override
    public String toString() {
        return "Team04cv1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
