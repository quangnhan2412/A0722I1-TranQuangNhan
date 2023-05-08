package com.example.furamaresotmanagentapplication.repository.facility;

import com.example.furamaresotmanagentapplication.entity.facility.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacilityRentRepository extends JpaRepository<RentType,Integer> {
}
