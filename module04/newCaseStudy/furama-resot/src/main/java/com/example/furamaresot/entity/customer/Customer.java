package com.example.furamaresot.entity.customer;

import com.example.furamaresot.entity.contract.Contract;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "customer_type_id", referencedColumnName = "id")
    private CustomerType customerType;

    @JsonBackReference
    @OneToMany(mappedBy = "customerContract")
    private Set<Contract> contracts;

    private String name;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    private Boolean gender;
    @Column(name = "id_card")
    private String idCard;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String email;
    private String address;


}
