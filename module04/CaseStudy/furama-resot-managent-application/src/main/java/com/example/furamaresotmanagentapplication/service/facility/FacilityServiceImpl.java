package com.example.furamaresotmanagentapplication.service.facility;

import com.example.furamaresotmanagentapplication.entity.facility.Facility;
import com.example.furamaresotmanagentapplication.repository.facility.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class FacilityServiceImpl implements FacilityService {
    @Autowired
    private FacilityRepository facilityRepository;

    @Override
    public Optional<Facility> findById(int id) {
        return Optional.ofNullable(facilityRepository.findById(id).orElse(null));
    }

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public Page<Facility> findAll(Pageable pageable) {
        return facilityRepository.findAll(pageable);
    }

    @Override
    public void remove(int id) {
        facilityRepository.deleteById(id);
    }

    @Override
    public void deleteAllByIdIn(Integer[] idx) {
        facilityRepository.deleteAllByIdIn(idx);
    }

    @Override
    public Page<Facility> searchAll(String name, String area, String standardRoom, Pageable pageable) {
        return facilityRepository.findAllByNameContainingOrFacilityFreeContainingOrStandardRoomContaining(name, area, standardRoom, pageable);
    }

    @Override
    public Page<Facility> searchAllInt(String key, Pageable pageable) {
        String name = key;
        String standardRoom= key;
        Integer area ;
        try {
            area = Integer.valueOf(key);
        }catch (NumberFormatException e){
            area = null;
        }
        return facilityRepository.findAllByNameContainingOrAreaIsLessThanEqualOrStandardRoomContaining(name,area,standardRoom ,pageable);
    }

}
