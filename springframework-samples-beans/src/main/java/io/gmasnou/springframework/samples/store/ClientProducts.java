package io.gmasnou.springframework.samples.store;

import io.gmasnou.springframework.samples.commons.Client;
import io.gmasnou.springframework.samples.commons.Product;

import java.util.Collection;

public class ClientProducts {

    private final Client client;
    private final Collection<Product> products;

    public ClientProducts(Client client, Collection<Product> products) {
        this.client = client;
        this.products = products;
    }

    public Client getClient() {
        return client;
    }

    public Collection<Product> getProducts() {
        return products;
    }
}
