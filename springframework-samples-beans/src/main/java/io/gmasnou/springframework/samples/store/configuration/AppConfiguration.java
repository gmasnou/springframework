package io.gmasnou.springframework.samples.store.configuration;

import io.gmasnou.springframework.samples.store.SaleNetwork;
import io.gmasnou.springframework.samples.store.internal.LoyaltyRepository;
import io.gmasnou.springframework.samples.store.internal.LoyaltyRepositoryImpl;
import io.gmasnou.springframework.samples.store.internal.PromotionRepository;
import io.gmasnou.springframework.samples.store.internal.PromotionRepositoryImpl;
import io.gmasnou.springframework.samples.store.internal.SaleNetworkImpl;
import io.gmasnou.springframework.samples.store.internal.entity.ClientEntity;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

@Configuration
public class AppConfiguration {

    @Bean
    public SaleNetwork saleNetwork(LoyaltyRepository loyaltyRepository,
                                   PromotionRepository promotionRepository) {

        return new SaleNetworkImpl(loyaltyRepository, promotionRepository);
    }

    @Bean
    public LoyaltyRepository loyaltyRepository(SessionFactory sessionFactory) throws SQLException {

        return new LoyaltyRepositoryImpl(sessionFactory);
    }

    @Bean
    public PromotionRepository promotionRepository(SessionFactory sessionFactory) {

        return new PromotionRepositoryImpl(sessionFactory);
    }

    @Bean
    public SessionFactory sessionFactory(ServiceRegistry serviceRegistry) {

        return new MetadataSources(serviceRegistry)
                .addAnnotatedClass(ClientEntity.class)
                .buildMetadata()
                .buildSessionFactory();
    }
}
