package com.example.managentcustomerrestful.service;

import com.example.managentcustomerrestful.model.Customer;

import java.util.Optional;

public interface GeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    public Customer save(Customer customer);

    void remove(Long id);
}
