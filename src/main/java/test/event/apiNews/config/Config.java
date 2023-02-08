package test.event.apiNews.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class Config {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/apinews");
        dataSource.setUsername("postgres");
        dataSource.setPassword("09451");
        dataSource.setDriverClassName("org.postgresql.Driver");
        return dataSource;
    }

}
