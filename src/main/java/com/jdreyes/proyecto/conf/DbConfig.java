package com.jdreyes.proyecto.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DbConfig {

    @Value("${usr}")
    private String usr;

    @Value("${crs}")
    private String crs;

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder builder = DataSourceBuilder.create();
//        builder.url("jdbc:sqlserver://192.168.10.136:1433;database=Northwind;trustServerCertificate=true");
        builder.url("jdbc:sqlserver://localhost:1433;database=Northwind;trustServerCertificate=true");
        builder.username(usr);
        builder.password(crs);
        return builder.build();
    }

}
