package com.rrezahatam.prospring6.chapter07.entities;


import jakarta.persistence.*;

import java.io.Serial;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "SINGER")
public class Singer extends AbstractEntity {
    @Serial
    private final static long serialVersionUID = 2L;

    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    private Set<Album> albums = new HashSet<>();
    private Set<Instrument> instruments = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "SINGER_INSTRUMENT",
            joinColumns = @JoinColumn(name = "SINGER_ID"),
            inverseJoinColumns = @JoinColumn(name = "INSTRUMENT_ID"))

    public Set<Instrument> getInstruments() {
        return instruments;
    }

    public boolean addInstrument(Instrument instrument) {
        return getInstruments().add(instrument);
    }

    public void setInstruments(Set<Instrument> instruments) {
        this.instruments = instruments;
    }

    @OneToMany(mappedBy = "singer", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }

    public boolean addAlbum(Album album) {
        album.setSinger(this);
        return getAlbums().add(album);
    }

    public void removeAlbum(Album album) {
        albums.remove(album);
    }

    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "BIRTH_DATE")
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String toString() {
        return "Singer - Id: " + id + ", First name: " + firstName
                + ", Last name: " + lastName + ", Birthday: " + birthDate;
    }
}
