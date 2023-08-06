package com.example.managentcustomerrestful.service;

import com.example.managentcustomerrestful.model.Customer;
import com.example.managentcustomerrestful.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerImplService implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Iterable findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer save(Customer  customer ) {
        return customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }
}
