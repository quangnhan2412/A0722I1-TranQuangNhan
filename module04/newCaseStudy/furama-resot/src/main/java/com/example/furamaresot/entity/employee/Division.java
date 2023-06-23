package com.example.furamaresot.entity.employee;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Division {
    @Id
    @GeneratedValue
    @Column(name = "division_id")
    private Integer divisionId;
    @Column(name = "division_name")
    private String divisionName;
    @JsonBackReference

    @OneToMany(mappedBy = "division",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
private Set<Employee> employees;


}
