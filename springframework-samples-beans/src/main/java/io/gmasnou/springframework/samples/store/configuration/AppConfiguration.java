package io.gmasnou.springframework.samples.store.configuration;

import io.gmasnou.springframework.samples.store.SaleNetwork;
import io.gmasnou.springframework.samples.store.internal.LoyaltyRepository;
import io.gmasnou.springframework.samples.store.internal.LoyaltyRepositoryImpl;
import io.gmasnou.springframework.samples.store.internal.PromotionRepository;
import io.gmasnou.springframework.samples.store.internal.PromotionRepositoryImpl;
import io.gmasnou.springframework.samples.store.internal.SaleNetworkImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AppConfiguration {

    @Bean
    public SaleNetwork saleNetwork(LoyaltyRepository loyaltyRepository,
                                   PromotionRepository promotionRepository) {

        return new SaleNetworkImpl(loyaltyRepository, promotionRepository);
    }

    @Bean
    public LoyaltyRepository loyaltyRepository(DataSource dataSource) {

        return new LoyaltyRepositoryImpl(dataSource);
    }

    @Bean
    public PromotionRepository promotionRepository(DataSource dataSource) {

        return new PromotionRepositoryImpl(dataSource);
    }
}
