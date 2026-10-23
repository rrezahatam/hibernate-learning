package com.rrezahatam.prospring6.chapter07.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "ALBUM")
public class Album extends AbstractEntity {
    @Serial
    private final static long serialVersionUID = 3L;

    private String title;
    private LocalDate releaseDate;

    private Singer singer;

    @ManyToOne
    @JoinColumn(name = "SINGER_ID")
    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    @Column
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "RELEASE_DATE")
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Album album = (Album) o;
        if (album.getId() != null && this.getId() != null) {
            return super.equals(o);
        }
        return title.equals(album.title) && releaseDate.equals(album.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), title, releaseDate);
    }

    @Override
    public String toString() {
        return "Album - Id: " + id + ", Singer id: " + (singer != null ? singer.getId() : "")
                + ", Title: " + title + ", Release Date: " + releaseDate;
    }
}
