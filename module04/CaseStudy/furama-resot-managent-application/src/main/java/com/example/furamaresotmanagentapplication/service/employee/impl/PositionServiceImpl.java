package com.example.furamaresotmanagentapplication.service.employee.impl;

import com.example.furamaresotmanagentapplication.entity.employee.Position;
import com.example.furamaresotmanagentapplication.repository.employee.PositionRepository;
import com.example.furamaresotmanagentapplication.service.employee.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionServiceImpl implements PositionService {
@Autowired
private PositionRepository positionRepository;
    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }
}
