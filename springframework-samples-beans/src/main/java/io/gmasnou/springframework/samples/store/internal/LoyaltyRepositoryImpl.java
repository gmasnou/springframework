package io.gmasnou.springframework.samples.store.internal;

import io.gmasnou.springframework.samples.commons.Client;
import io.gmasnou.springframework.samples.commons.Loyalty;
import io.gmasnou.springframework.samples.store.internal.entity.ClientEntity;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;

import static java.lang.System.out;

public class LoyaltyRepositoryImpl implements LoyaltyRepository {
    private final SessionFactory sessionFactory;

    public LoyaltyRepositoryImpl(SessionFactory sessionFactory) throws SQLException {
        this.sessionFactory = sessionFactory;

        sessionFactory.inTransaction(session -> {
            for (int i = 0; i < 10; i++) {
                ClientEntity clientEntity = new ClientEntity();
                clientEntity.setId(UUID.randomUUID().toString());
                clientEntity.setFirstName("Guillem");
                clientEntity.setLastName("Masnou Baltanas");
                session.persist(clientEntity);
            }
            session.createSelectionQuery("from ClientEntity", ClientEntity.class)
                    .getResultList()
                    .forEach(c -> out.println("Event (" + c.getId() + ") : " + c.getFirstName()));
        });

    }

    @Override
    public Optional<Loyalty> get(Client client) {


        return Optional.empty();
    }
}
