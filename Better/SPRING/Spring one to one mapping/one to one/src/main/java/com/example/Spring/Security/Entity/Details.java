package com.example.Spring.Security.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@Entity
//@Table
//@Data
//
//@NoArgsConstructor
//@ToString
public class Details {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer detailsId;

    private Integer age;

    private String branch;

    private String fatherName;

    @OneToOne(cascade = CascadeType.ALL)
    private Student student;

    public Details(Integer detailsId, Integer age, String branch, String fatherName) {
        this.detailsId = detailsId;
        this.age = age;
        this.branch = branch;
        this.fatherName = fatherName;

    }


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
