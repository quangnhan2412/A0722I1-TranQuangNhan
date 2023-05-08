package com.example.furamaresotmanagentapplication.service.employee.impl;

import com.example.furamaresotmanagentapplication.entity.employee.Division;
import com.example.furamaresotmanagentapplication.repository.employee.DivisionRepository;
import com.example.furamaresotmanagentapplication.service.employee.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service

public class DivisionServiceImpl implements DivisionService {
    @Autowired
    private DivisionRepository divisionRepository;
    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }
}
