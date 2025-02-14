package org.example.chapter09.dto;

public class MemberDTO {
    private String username;
    private int age;

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

    public MemberDTO(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
