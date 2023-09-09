package io.gmasnou.springframework.samples.store.internal.entity;

import io.gmasnou.springframework.samples.commons.Loyalty;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "client", schema = "test")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name", columnDefinition = "varchar2(20)")
    private String name;

    public void upgrade(Loyalty loyalty) {

    }
}
