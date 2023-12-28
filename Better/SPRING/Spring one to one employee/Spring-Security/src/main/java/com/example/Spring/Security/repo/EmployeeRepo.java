package com.example.Spring.Security.repo;


import com.example.Spring.Security.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
    Optional<Employee> findByEmpId(String empId);

    Optional<Employee> findByMail(String empId);


}
