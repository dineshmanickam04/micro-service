package com.example.department.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "DEPARTMENT")
public class Department {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEPARTMENT_ID")
    private Long id;

    @Column(name = "DEPARTMENT_NAME")
    private String departmentName;

    @Column(name = "NAME")
    private String name;


}
