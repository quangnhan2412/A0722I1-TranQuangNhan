package com.example.furamaresotmanagentapplication.entity.facility;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "rent_type")
public class RentType {
    @Id
    private Integer id;
    private String name;
    @JsonBackReference
    @OneToMany(mappedBy = "rentTypes")
    private Set<Facility>facilities;

    public RentType() {
    }

    public RentType(Integer id, String name, Set<Facility> facilities) {
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
