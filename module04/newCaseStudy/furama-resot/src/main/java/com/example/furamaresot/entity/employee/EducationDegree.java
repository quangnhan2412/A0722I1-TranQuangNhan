package com.example.furamaresot.entity.employee;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "education_degree")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "education_degree_id")
    private Integer educationDegreeId;
    @Column(name = "education_degree_name")
    private String educationDegreeName;
    @JsonBackReference

    @OneToMany(mappedBy = "educationDegree", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Employee> employees;
}
