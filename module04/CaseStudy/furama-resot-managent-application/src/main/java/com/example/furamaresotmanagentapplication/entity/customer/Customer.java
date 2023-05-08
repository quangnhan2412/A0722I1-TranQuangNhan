package com.example.furamaresotmanagentapplication.entity.customer;

import com.example.furamaresotmanagentapplication.entity.contract.Contract;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
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

    public Customer() {
    }

    public Customer(Integer id, CustomerType customerType, Set<Contract> contracts, String name, Date dateOfBirth, Boolean gender, String idCard, String phoneNumber, String email, String address) {
        this.id = id;
        this.customerType = customerType;
        this.contracts = contracts;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
