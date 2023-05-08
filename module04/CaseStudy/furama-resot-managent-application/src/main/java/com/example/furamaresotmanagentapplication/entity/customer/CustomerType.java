package com.example.furamaresotmanagentapplication.entity.customer;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "customer_type")

public class CustomerType {
    @Id
    private Integer id;
    private String name;
    @JsonBackReference
    @OneToMany(mappedBy = "customerType")
    private Set<Customer> customers;

    public CustomerType() {
    }

    public CustomerType(Integer id, String name, Set<Customer> customers) {
        this.id = id;
        this.name = name;
        this.customers = customers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}
