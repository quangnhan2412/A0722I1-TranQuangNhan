package com.example.furamaresotmanagentapplication.entity.employee;

import com.example.furamaresotmanagentapplication.entity.contract.Contract;
import com.example.furamaresotmanagentapplication.entity.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Integer id;
@NotBlank(message = "Vui lòng nhập tên!")
    private String name;
    @Column(name = "date_of_birth")
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private Date dateOfBirth;
    @Column(name = "id_card")
    @NotBlank(message = "Vui lòng nhập id Card !")
    private String idCard;
    @NotNull(message = "Số lương không được để trống")
    @Min(value = 0, message = "Số lương không được âm")
    private Double salary;
    @Column(name = "phone_number")
//    @Pattern(regexp = "^(03[2-9]|05[689]|07[06-9]|08[1-9]|09[0-9]|01[2-9])\\d{7}$\n",
//    message = " Viettel (03[2-9]), Gmobile (05[689]), Vinaphone (07[06-9]), Mobifone (08[1-9]), Vietnamobile (09[0-9]), Itelecom (01[2-9]).")
    private String phoneNumber;
    @Email
    private String email;
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

    public Employee() {
    }

    public Employee(Integer id, String name, Date dateOfBirth, String idCard, Double salary, String phoneNumber, String email, String address, Position position, EducationDegree educationDegree, Division division, User user, Set<Contract> contracts) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.idCard = idCard;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
        this.user = user;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }
    public void setDateOfBirth(){
        java.util.Date date=new java.util.Date();
        this.dateOfBirth = date;
    }
}
