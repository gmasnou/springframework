package io.gmasnou.springframework.samples.store.internal;

import io.gmasnou.springframework.samples.commons.Client;
import io.gmasnou.springframework.samples.commons.Loyalty;
import io.gmasnou.springframework.samples.store.internal.entity.ClientEntity;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class LoyaltyRepositoryImpl implements LoyaltyRepository {
    private final SessionFactory sessionFactory;

    public LoyaltyRepositoryImpl(SessionFactory sessionFactory) throws SQLException {
        this.sessionFactory = sessionFactory;

        sessionFactory.inTransaction(session -> {

            for (int i = 0; i < 10; i++) {
                ClientEntity clientEntity = new ClientEntity();
                clientEntity.setId(UUID.randomUUID().toString());
                clientEntity.setFirstName("Guillem" + i);
                clientEntity.setLastName("Masnou Baltanas");
                session.persist(clientEntity);
            }

            Query<ClientEntity> query = session.createQuery("FROM ClientEntity", ClientEntity.class);
            query.setFirstResult(0);
            query.setMaxResults(2);
            List<ClientEntity> clients = query.list();
            clients.forEach(c -> System.out.println(c.getFirstName()));
        });


    }

    @Override
    public Optional<Loyalty> get(Client client) {


        return Optional.empty();
    }
}
