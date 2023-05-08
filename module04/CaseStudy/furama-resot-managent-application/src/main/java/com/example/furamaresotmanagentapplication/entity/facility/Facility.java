package com.example.furamaresotmanagentapplication.entity.facility;

import com.example.furamaresotmanagentapplication.entity.contract.Contract;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;


@Entity
public class Facility {
    @Id
    @GeneratedValue
    private Integer id;
    @NotBlank(message = "Không được để trống !")
    @Size(min = 2, max=20, message = "Tên phải từ 2 ký tự trở lên")
    private String name;
    @NotNull(message = "Vui lòng không để trống dòng này !!")
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

    public Facility() {
    }

    public Facility(Integer id, String name, Integer area, Integer cost, Integer maxPeople, RentType rentTypes, FacilityType facilityTypes, String standardRoom, String descriptionOtherConvenience, Double poolArea, Integer numberOfFloors, String facilityFree, Set<Contract> contracts) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.rentTypes = rentTypes;
        this.facilityTypes = facilityTypes;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.facilityFree = facilityFree;
        this.contracts = contracts;
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

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public RentType getRentTypes() {
        return rentTypes;
    }

    public void setRentTypes(RentType rentTypes) {
        this.rentTypes = rentTypes;
    }

    public FacilityType getFacilityTypes() {
        return facilityTypes;
    }

    public void setFacilityTypes(FacilityType facilityTypes) {
        this.facilityTypes = facilityTypes;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }
}
