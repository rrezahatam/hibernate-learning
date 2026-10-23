package com.rrezahatam.prospring6.chapter07.entities;


import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

import static jakarta.persistence.GenerationType.IDENTITY;

@MappedSuperclass
public class AbstractEntity implements Serializable {

    @Serial
    private final static long serialVersionUID = 1L;

    protected long id;
    protected int version;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Version
    @Column(name = "VERSION")
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
