package com.example.Spring.Security.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String empId;
    private String displayName;
    private String givenName;
    private String jobTitle;
    private String mail;
    private String mobilePhone;
    private String officeLocation;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Leave leave;


}
