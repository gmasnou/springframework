package io.gmasnou.springframework.samples.store.internal;

import io.gmasnou.springframework.samples.commons.Client;
import io.gmasnou.springframework.samples.commons.Loyalty;

import java.util.Optional;

public interface LoyaltyRepository {

    Optional<Loyalty> get(Client client);
}