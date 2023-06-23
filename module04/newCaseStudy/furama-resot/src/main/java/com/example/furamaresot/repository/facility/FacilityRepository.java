package com.example.furamaresot.repository.facility;

import com.example.furamaresot.entity.facility.Facility;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FacilityRepository extends JpaRepository<Facility, Integer> {
    void deleteAllByIdIn(Integer[] idx);
}
