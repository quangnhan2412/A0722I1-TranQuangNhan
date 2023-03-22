package org.example.entity;

import javax.persistence.*;

@Entity
@Table
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private String nameSong;
private String performingArtist;
private String typeMusic;
private String pathMusic;

    public Song() {
    }

    public Song(Integer id, String nameSong, String performingArtist, String typeMusic, String pathMusic) {
        this.id = id;
        this.nameSong = nameSong;
        this.performingArtist = performingArtist;
        this.typeMusic = typeMusic;
        this.pathMusic = pathMusic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getPerformingArtist() {
        return performingArtist;
    }

    public void setPerformingArtist(String performingArtist) {
        this.performingArtist = performingArtist;
    }

    public String getTypeMusic() {
        return typeMusic;
    }

    public void setTypeMusic(String typeMusic) {
        this.typeMusic = typeMusic;
    }

    public String getPathMusic() {
        return pathMusic;
    }

    public void setPathMusic(String pathMusic) {
        this.pathMusic = pathMusic;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", nameSong='" + nameSong + '\'' +
                ", performingArtist='" + performingArtist + '\'' +
                ", typeMusic='" + typeMusic + '\'' +
                ", pathMusic='" + pathMusic + '\'' +
                '}';
    }
}
