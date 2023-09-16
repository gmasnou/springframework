package io.gmasnou.springframework.samples.store.internal;

import io.gmasnou.springframework.samples.commons.Product;
import io.gmasnou.springframework.samples.commons.Promotion;
import org.hibernate.SessionFactory;

import java.util.Optional;

public class PromotionRepositoryImpl implements PromotionRepository {

    private final SessionFactory sessionFactory;

    public PromotionRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Optional<Promotion> get(Product product) {
        return Optional.empty();
    }
}
