package com.example.furamaresotmanagentapplication.repository.facility;

import com.example.furamaresotmanagentapplication.entity.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import java.util.List;


public interface FacilityRepository extends JpaRepository<Facility, Integer> {
    void deleteAllByIdIn(Integer[] idx);

Page<Facility> findAllByNameContainingOrFacilityFreeContainingOrStandardRoomContaining(String name, String area, String standardRoom, Pageable pageable);
Page<Facility> findAllByNameContainingOrAreaIsLessThanEqualOrStandardRoomContaining(String key, Integer area,String standRoom, Pageable pageable);
}
