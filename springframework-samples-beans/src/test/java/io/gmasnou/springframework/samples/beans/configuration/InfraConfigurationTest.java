package io.gmasnou.springframework.samples.beans.configuration;

import io.gmasnou.springframework.samples.store.configuration.AppConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

@Configuration
@Import(value = {AppConfiguration.class})
public class InfraConfigurationTest {

    @Bean
    public DataSource dataSource() {

        return null;
    }
}
