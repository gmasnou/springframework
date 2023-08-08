package io.gmasnou.springframework.samples.store;

import io.gmasnou.springframework.samples.commons.Client;
import io.gmasnou.springframework.samples.commons.Product;

import java.util.Collection;

public record SaleSummary(Client client, Collection<Product> products) {

}
