package com.rrezahatam.prospring6.chapter07;

import com.rrezahatam.prospring6.chapter07.config.HibernateConfig;
import com.rrezahatam.prospring6.chapter07.dao.SingerDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HibernateDemoV1 {
    private static final Logger LOGGER = LoggerFactory.getLogger(HibernateDemoV1.class);

    public static void main(String[] args){
        var ctx = new AnnotationConfigApplicationContext(HibernateConfig.class);
        var singerDao = ctx.getBean(SingerDao.class);

        LOGGER.info(" ---- Listing singers:");
        singerDao.findAll().forEach( s -> LOGGER.info(s.toString()));
        ctx.close();
    }
}
