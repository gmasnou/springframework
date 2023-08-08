package io.gmasnou.springframework.samples.store.internal;

import io.gmasnou.springframework.samples.commons.Client;
import io.gmasnou.springframework.samples.commons.Product;
import io.gmasnou.springframework.samples.store.ClientProducts;
import io.gmasnou.springframework.samples.store.SaleNetwork;
import io.gmasnou.springframework.samples.store.SaleSummary;

import java.util.Collection;

public class SaleNetworkImpl implements SaleNetwork {

    private final LoyaltyRepository loyaltyRepository;
    private final PromotionRepository promotionRepository;

    public SaleNetworkImpl(LoyaltyRepository loyaltyRepository, PromotionRepository promotionRepository) {

        this.loyaltyRepository = loyaltyRepository;
        this.promotionRepository = promotionRepository;
    }

    @Override
    public SaleSummary saleNetworkFor(ClientProducts sale) {

        Client client = sale.getClient();
        Collection<Product> products = sale.getProducts();

        this.loyaltyRepository.get(client).ifPresent(client::upgrade);
        products.forEach(product -> this.promotionRepository.get(product).ifPresent(product::applyPromotion));

        return new SaleSummary(client, products);
    }
}
