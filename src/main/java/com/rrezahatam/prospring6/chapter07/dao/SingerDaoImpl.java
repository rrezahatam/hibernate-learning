package com.rrezahatam.prospring6.chapter07.dao;

import com.rrezahatam.prospring6.chapter07.entities.Singer;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Transactional(readOnly = true)
@Repository("singerDao")
public class SingerDaoImpl implements SingerDao{
    private static Logger LOGGER = LoggerFactory.getLogger(SingerDaoImpl.class);
    private SessionFactory sessionFactory;

    public SingerDaoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }


    @Transactional(readOnly = true)
    @Override
    public List<Singer> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Singer s").list();
    }

    @Override
    public List<Singer> findAllWithAlbum() {
        return List.of();
    }

    @Override
    public Singer findById(Long id) {
        return null;
    }

    @Override
    public Singer save(Singer singer) {
        return null;
    }

    @Override
    public void delete(Singer singer) {

    }

}
