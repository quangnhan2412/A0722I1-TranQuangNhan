package com.example.furamaresotmanagentapplication.repository.employee;

import com.example.furamaresotmanagentapplication.entity.employee.Division;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DivisionRepository extends JpaRepository<Division,Integer> {
}
