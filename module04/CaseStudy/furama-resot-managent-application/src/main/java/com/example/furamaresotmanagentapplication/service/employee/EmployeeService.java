package com.example.furamaresotmanagentapplication.service.employee;

import com.example.furamaresotmanagentapplication.entity.employee.Employee;
import com.example.furamaresotmanagentapplication.entity.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.Optional;

public interface EmployeeService {
    Optional<Employee> findById(Integer id);
    void save(Employee employee);
    Page<Employee> findAll(Pageable pageable);
    void remove(Integer id);
    void deleteByAllId(Integer[] ids);
    Page<Employee> searchAll(String key, Pageable pageable);

}
