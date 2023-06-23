package com.example.furamaresot.entity.facility;

import com.example.furamaresot.entity.contract.Contract;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Facility {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer area;
    private Integer cost;
    @Column(name = "max_people")
    private Integer maxPeople;
    @ManyToOne
    @JoinColumn(name = "rent_type_id", referencedColumnName = "id")
    private RentType rentTypes;
    @ManyToOne
    @JoinColumn(name = "facility_type_id", referencedColumnName = "id")
    private FacilityType facilityTypes;

    @Column(name = "standard_room")
    private String standardRoom;
    @Column(name = "description_other_convenience")
    private String descriptionOtherConvenience;
    @Column(name = "pool_area")
    private Double poolArea;
    @Column(name = "number_of_floors")
    private Integer numberOfFloors;
    @Column(name = "facility_free")
    private String facilityFree;
    @JsonBackReference
    @OneToMany(mappedBy = "facilities")
    private Set<Contract> contracts;
}

