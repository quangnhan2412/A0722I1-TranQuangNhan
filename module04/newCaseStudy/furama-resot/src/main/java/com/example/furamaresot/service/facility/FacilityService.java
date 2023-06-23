package com.example.furamaresot.service.facility;

import com.example.furamaresot.entity.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface FacilityService {
    Optional<Facility> findById(int id);
    void save(Facility facility);
    Page<Facility> findAll(Pageable pageable);

    void remove(int id);
    void deleteAllByIdIn(Integer[] ids);
}
