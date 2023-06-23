package com.example.furamaresot.entity.customer;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer_type")

public class CustomerType {
    @Id
    private Integer id;
    private String name;
    @JsonBackReference
    @OneToMany(mappedBy = "customerType")
    private Set<Customer> customers;

}
