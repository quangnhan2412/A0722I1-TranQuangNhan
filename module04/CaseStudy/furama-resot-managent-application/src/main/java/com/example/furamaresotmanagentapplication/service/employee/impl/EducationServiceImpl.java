package com.example.furamaresotmanagentapplication.service.employee.impl;

import com.example.furamaresotmanagentapplication.entity.employee.EducationDegree;
import com.example.furamaresotmanagentapplication.repository.employee.EducationDegreeRepository;
import com.example.furamaresotmanagentapplication.service.employee.EducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EducationServiceImpl implements EducationDegreeService {

    @Autowired
    private EducationDegreeRepository educationDegreeRepository;
    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }
}
