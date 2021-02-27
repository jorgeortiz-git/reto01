package com.reto01.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class H2Config {

    private static final Logger log = LoggerFactory.getLogger(H2Config.class);

    @Bean
    public DataSource getDataSource() {
        log.info("[h2] embedded up");
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setName("dbtest")
                .addScript("classpath:/scripts/schema.sql")
                .addScript("classpath:/scripts/data.sql")
                .setScriptEncoding("UTF-8")
                .build();
    }
}
