package com.rrezahatam.prospring6.chapter07.dao;

import com.rrezahatam.prospring6.chapter07.entities.Singer;

import java.util.List;
import java.util.Set;

public interface SingerDao {

    List<Singer> findAll();
    List<Singer> findAllWithAlbum();
    Singer findById(Long id);
    Singer save(Singer singer);
    void delete(Singer singer);

}
