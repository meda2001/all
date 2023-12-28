package com.example.Spring.Security.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.service.annotation.GetExchange;

@Entity
@Table(name = "leaves")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Leave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated
    private LeaveType leaveType;


    private String fromDate;

    private String toDate;

    private Integer leaveDuration;

    private Integer totalLeaves;

    private Integer remainingBalance;

    private String remarks;





}
