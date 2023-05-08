package com.example.furamaresotmanagentapplication.repository.customer;

import com.example.furamaresotmanagentapplication.entity.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
