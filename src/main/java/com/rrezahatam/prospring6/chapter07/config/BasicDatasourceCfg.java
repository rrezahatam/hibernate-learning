package com.rrezahatam.prospring6.chapter07.config;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@PropertySource("classpath:db/jdbc.properties")
public class BasicDatasourceCfg {
    private static Logger LOGGER = LoggerFactory.getLogger(BasicDatasourceCfg.class);

    @Value("${jdbc.driverClassName}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Bean
    public DataSource dataSource(){
        try{
            var hc = new HikariConfig();
            hc.setDriverClassName(driverClassName);
            hc.setJdbcUrl(url);
            hc.setUsername(username);
            hc.setPassword(password);
            var dataSource = new HikariDataSource(hc);
            dataSource.setMaximumPoolSize(25);
            return dataSource;
        } catch (Exception e) {
            LOGGER.info("DBCP DataSource bean cannot be created!", e);
            return null;
        }
    }
}
