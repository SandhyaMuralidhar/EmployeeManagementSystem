package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.pojo.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String> {

}
