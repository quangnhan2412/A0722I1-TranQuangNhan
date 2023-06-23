package com.example.furamaresot.entity.facility;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="facility_type")
public class FacilityType {
    @Id
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "facilityTypes")
    private Set<Facility>facilities;


}
