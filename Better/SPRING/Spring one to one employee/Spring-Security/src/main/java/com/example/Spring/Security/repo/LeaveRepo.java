package com.example.Spring.Security.repo;

import com.example.Spring.Security.entity.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LeaveRepo extends JpaRepository<Leave,Integer> {
}
