package com.example.furamaresot.repository.facility;

import com.example.furamaresot.entity.facility.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacilityRentRepository extends JpaRepository<RentType,Integer> {
}
