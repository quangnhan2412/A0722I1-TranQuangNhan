package com.example.managentcustomerrestful.repository;

import com.example.managentcustomerrestful.model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer,Long> {
}
