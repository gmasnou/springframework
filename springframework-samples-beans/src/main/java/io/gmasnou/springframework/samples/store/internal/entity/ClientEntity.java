package io.gmasnou.springframework.samples.store.internal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients", schema = "sample")
public class ClientEntity {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "firstName", columnDefinition = "varchar(255)")
    private String firstName;
    @Column(name = "lastName", columnDefinition = "varchar(255)")
    private String lastName;
    @Column(name = "address", columnDefinition = "varchar(255)")
    private String address;
    @Column(name = "city", columnDefinition = "varchar(255)")
    private String city;

    public ClientEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
