package com.example.furamaresotmanagentapplication.entity.facility;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name="facility_type")
public class FacilityType {
    @Id
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "facilityTypes")
    private Set<Facility>facilities;

    public FacilityType() {
    }

    public FacilityType(Integer id, String name, Set<Facility> facilities) {
        this.id = id;
        this.name = name;
        this.facilities = facilities;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(Set<Facility> facilities) {
        this.facilities = facilities;
    }
}
