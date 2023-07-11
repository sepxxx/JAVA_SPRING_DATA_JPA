package com.bnk.spring.springboot.spring_data_jpa.dao;

import com.bnk.spring.springboot.spring_data_jpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    public Employee findAllByName(String name);
}
