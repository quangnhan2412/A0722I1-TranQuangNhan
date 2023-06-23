package com.example.furamaresot.service.facility;


import com.example.furamaresot.entity.facility.FacilityType;
import com.example.furamaresot.repository.facility.FacilityTypeRepository;
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
