package com.example.furamaresotmanagentapplication.entity.contract;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "attach_facility")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttachFacility {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Double cost;
    private String unit;
    private String status;
    @JsonBackReference
    @OneToMany(mappedBy = "attachFacility")
    private Set<ContractDetail> contractDetails;
}
