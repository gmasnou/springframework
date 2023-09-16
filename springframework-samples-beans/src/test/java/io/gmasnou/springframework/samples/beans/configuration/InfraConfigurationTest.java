package io.gmasnou.springframework.samples.beans.configuration;

import io.gmasnou.springframework.samples.store.configuration.AppConfiguration;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.h2.jdbcx.JdbcConnectionPool;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.sql.Connection;
import java.sql.SQLException;

@Configuration
@Import(value = {AppConfiguration.class})
public class InfraConfigurationTest {

    private static final String URL = "jdbc:h2:mem:test";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "";


    @Bean
    public StandardServiceRegistry standardServiceRegistry() throws SQLException, LiquibaseException {

        initialize();

        StandardServiceRegistry registry =
                new StandardServiceRegistryBuilder()
                        .loadProperties("hibernate-test.properties")
                        .build();
        return registry;
    }

    public void initialize() throws SQLException, LiquibaseException {

        final JdbcConnectionPool cp = JdbcConnectionPool.create(URL, USERNAME, PASSWORD);
        populateWithLiquibase(cp.getConnection());
    }

    private void populateWithLiquibase(Connection connection) throws LiquibaseException {

        Database database = database = DatabaseFactory.getInstance()
                .findCorrectDatabaseImplementation(new JdbcConnection(connection));
        Liquibase liquibase = new Liquibase("db/changelog.yaml", new ClassLoaderResourceAccessor(), database);
        liquibase.update();
    }
}
