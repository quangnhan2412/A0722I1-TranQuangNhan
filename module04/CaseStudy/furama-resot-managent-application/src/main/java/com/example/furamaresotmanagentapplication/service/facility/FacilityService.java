package com.example.furamaresotmanagentapplication.service.facility;

import com.example.furamaresotmanagentapplication.entity.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Optional;

public interface FacilityService {
    Optional<Facility> findById(int id);

    void save(Facility facility);

    Page<Facility> findAll(Pageable pageable);

    void remove(int id);

    void deleteAllByIdIn(Integer[] ids);

    Page<Facility> searchAll(String name, String area, String standardRoom, Pageable pageable);

    Page<Facility> searchAllInt(  String key, Pageable pageable);
}
