package com.example.furamaresotmanagentapplication.repository.employee;

import com.example.furamaresotmanagentapplication.entity.employee.Employee;
import com.example.furamaresotmanagentapplication.entity.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    void deleteAllByIdIn(Integer[] idx);
    Page<Employee>findAllByNameContainingOrSalaryOrAddressContaining(String name, Double salary, String address,Pageable pageable);

}
