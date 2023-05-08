package com.example.furamaresotmanagentapplication.service.facility;


import com.example.furamaresotmanagentapplication.entity.facility.FacilityType;
import com.example.furamaresotmanagentapplication.repository.facility.FacilityTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class FacilityTypeServiceImpl implements FacilityTypeService{
    @Autowired
    private FacilityTypeRepository facilityTypeRepository;
    @Override
    public List<FacilityType> findAll() {
        return facilityTypeRepository.findAll();
    }
}
