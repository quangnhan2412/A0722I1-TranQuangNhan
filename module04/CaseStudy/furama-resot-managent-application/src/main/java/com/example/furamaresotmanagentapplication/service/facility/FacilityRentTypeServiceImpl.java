package com.example.furamaresotmanagentapplication.service.facility;

import com.example.furamaresotmanagentapplication.entity.facility.RentType;
import com.example.furamaresotmanagentapplication.repository.facility.FacilityRentRepository;
import com.example.furamaresotmanagentapplication.repository.facility.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityRentTypeServiceImpl implements FacilityRentTypeService {
    @Autowired
    private FacilityRentRepository facilityRentRepository;

    @Override
    public List<RentType> findAll() {
        return facilityRentRepository.findAll();
    }
}
