package com.example.validatingforminput.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;


@Entity
@Table(name="users")
public class User {
    @NotBlank(message = "{notempty}")
    @Id
    @Size(min = 2, max = 30)
    private String name;

    @Min(18)
    private int age;

    public User() {
    }

    public User(@NotEmpty  @Size(min = 2, max = 30) String name,    @Min(18) int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
