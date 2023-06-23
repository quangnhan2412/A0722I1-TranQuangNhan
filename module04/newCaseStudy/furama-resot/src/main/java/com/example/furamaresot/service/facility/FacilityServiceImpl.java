package com.example.furamaresot.service.facility;

import com.example.furamaresot.entity.facility.Facility;
import com.example.furamaresot.repository.facility.FacilityRepository;
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

}
