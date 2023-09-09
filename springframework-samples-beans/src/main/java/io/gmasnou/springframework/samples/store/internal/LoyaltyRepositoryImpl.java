package io.gmasnou.springframework.samples.store.internal;

import io.gmasnou.springframework.samples.commons.Client;
import io.gmasnou.springframework.samples.commons.Loyalty;

import javax.sql.DataSource;
import java.util.Optional;

public class LoyaltyRepositoryImpl implements LoyaltyRepository {

    private final DataSource dataSource;

    public LoyaltyRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Optional<Loyalty> get(Client client) {
        return Optional.empty();
    }
}
