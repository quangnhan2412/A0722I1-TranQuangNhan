package com.example.furamaresotmanagentapplication.service.employee.impl;

import com.example.furamaresotmanagentapplication.entity.employee.Employee;
import com.example.furamaresotmanagentapplication.repository.employee.EmployeeRepository;
import com.example.furamaresotmanagentapplication.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Optional<Employee> findById(Integer id) {
        return Optional.ofNullable(employeeRepository.findById(id).orElse(null));
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public void remove(Integer id) {
employeeRepository.deleteById(id);
    }

    @Override
    public void deleteByAllId(Integer[] ids) {
employeeRepository.deleteAllByIdIn(ids);
    }

    @Override
    public Page<Employee> searchAll(String key, Pageable pageable) {
        String name = key;
        String address = key;

        Double salary ;
        try {
            salary = Double.valueOf(key);
        }catch (NumberFormatException e){
            salary = null;
        }
        return employeeRepository.findAllByNameContainingOrSalaryOrAddressContaining(name,salary,address ,pageable);
    }
}
