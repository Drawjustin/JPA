package org.example.chapter08.correctv1.domain;//package org.example.chapter07.correctv1.domain;

import jakarta.persistence.Entity;

@Entity
public class Album08cv1 extends Item08Cv1 {
    private String artist;
    private String etc;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }
}
