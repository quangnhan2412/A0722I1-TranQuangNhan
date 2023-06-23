package com.example.furamaresot.entity.employee;

import com.example.furamaresot.entity.contract.Contract;
import com.example.furamaresot.entity.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Column(name = "id_card")
    private String idCard;
    private Double salary;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String address;
    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "education_degree_id")
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "division_id")
    private Division division;

    @OneToOne
    @JoinColumn(name ="username",referencedColumnName = "username")
    private User user;
    @JsonBackReference


    @OneToMany(mappedBy = "employee",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Contract> contracts;

}
