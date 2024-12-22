package org.example.chapter08.correctv1.domain;//package org.example.chapter07.correctv1.domain;

import jakarta.persistence.Entity;

@Entity
public class Movie08Cv1 extends Item08Cv1 {
    private String director;
    private String actor;

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }
}
