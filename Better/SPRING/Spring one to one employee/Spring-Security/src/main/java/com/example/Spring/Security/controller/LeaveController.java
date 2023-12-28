package com.example.Spring.Security.controller;


import com.example.Spring.Security.entity.Employee;
import com.example.Spring.Security.repo.EmployeeRepo;
import com.example.Spring.Security.repo.LeaveRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LeaveController {

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private LeaveRepo leaveRepo;

    @GetMapping("/")
    public List<Employee> getAllEmployee(){
        return employeeRepo.findAll();
    }

    @PostMapping("/post")
    public Employee postEmployee(@RequestBody Employee employee){
        leaveRepo.save(employee.getLeave());
        return employeeRepo.save(employee);

    }

    @GetMapping("{id}")

    public Optional<Employee> findByEmpId(@PathVariable Integer id){
        return employeeRepo.findById(id);
    }



}
