package no.ciber.academy;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.net.URISyntaxException;
import java.sql.SQLException;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class LocalApplication {

    public static void main(String[] args) throws SQLException {

        SpringApplication.run(LocalApplication.class, args);
        org.h2.tools.Server.createWebServer("-webPort", "8081").start();
    }

    @Bean
    public DataSource dataSource() throws URISyntaxException {
        JdbcDataSource basicDataSource = new JdbcDataSource();
        basicDataSource.setUrl("jdbc:h2:test");
        return basicDataSource;
    }
}
