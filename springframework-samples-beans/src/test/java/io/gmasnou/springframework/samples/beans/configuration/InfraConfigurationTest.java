package io.gmasnou.springframework.samples.beans.configuration;

import io.gmasnou.springframework.samples.store.configuration.AppConfiguration;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.h2.jdbcx.JdbcConnectionPool;
import org.h2.jdbcx.JdbcDataSource;
import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Configuration
@Import(value = {AppConfiguration.class})
public class InfraConfigurationTest {

    private static final String URL = "jdbc:h2:mem:test;INIT=CREATE SCHEMA IF NOT EXISTS testww";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "";

    @Bean
    public DataSource dataSource(Connection connection) throws SQLException {

        JdbcDataSource jdbcDataSource = new JdbcDataSource();
        jdbcDataSource.setURL(URL);
        jdbcDataSource.setUser(USERNAME);
        jdbcDataSource.setPassword(PASSWORD);
        liquibase(connection);
        Server.startWebServer(connection);
        return jdbcDataSource;
    }

    @Bean
    public Connection connection() throws SQLException {

        final JdbcConnectionPool cp = JdbcConnectionPool.create(URL, USERNAME, PASSWORD);
        return cp.getConnection();
    }

    private void liquibase(Connection connection) {

        Database database = null;
        try {
            database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(connection));
        } catch (DatabaseException e) {
            throw new RuntimeException(e);
        }
        Liquibase liquibase = new Liquibase("db/changelog.yaml", new ClassLoaderResourceAccessor(), database);
        try {
            liquibase.update();
        } catch (LiquibaseException e) {
            throw new RuntimeException(e);
        }
    }
}
