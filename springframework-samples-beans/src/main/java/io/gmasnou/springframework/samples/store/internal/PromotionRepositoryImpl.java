package io.gmasnou.springframework.samples.store.internal;

import io.gmasnou.springframework.samples.commons.Product;
import io.gmasnou.springframework.samples.commons.Promotion;

import javax.sql.DataSource;
import java.util.Optional;

public class PromotionRepositoryImpl implements PromotionRepository {

    private final DataSource dataSource;

    public PromotionRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Optional<Promotion> get(Product product) {
        return Optional.empty();
    }
}
