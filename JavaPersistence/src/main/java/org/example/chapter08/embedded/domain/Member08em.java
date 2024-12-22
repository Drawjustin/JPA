//package org.example.chapter08.embedded.domain;
//
//import jakarta.persistence.*;
//
//@Entity
//public class Member08em {
//    @Id
//    @GeneratedValue
//    @Column(name = "MEMBER_ID")
//    private Long id;
//    private String username;
//
//    @Embedded
//    private Period06do period06do;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public Period06do getPeriod() {
//        return period06do;
//    }
//
//    public void setPeriod(Period06do period06do) {
//        this.period06do = period06do;
//    }
//}
