package com.example.furamaresot.entity.contract;

import com.example.furamaresot.entity.customer.Customer;
import com.example.furamaresot.entity.employee.Employee;
import com.example.furamaresot.entity.facility.Facility;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contract {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    private Double deposit;
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;
    @JsonBackReference
    @OneToMany(mappedBy = "contracts")
    private Set<ContractDetail> contractDetails;
    @ManyToOne
    @JoinColumn(name = "facility_id" , referencedColumnName = "id")
    private Facility facilities;
    @ManyToOne
    @JoinColumn(name = "customer_id" , referencedColumnName = "id")
    private Customer customerContract;
}
