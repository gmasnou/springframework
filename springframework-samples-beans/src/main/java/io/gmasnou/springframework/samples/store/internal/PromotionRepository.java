package io.gmasnou.springframework.samples.store.internal;

import io.gmasnou.springframework.samples.commons.Product;
import io.gmasnou.springframework.samples.commons.Promotion;

import java.util.Optional;

public interface PromotionRepository {

    Optional<Promotion> get(Product product);
}
