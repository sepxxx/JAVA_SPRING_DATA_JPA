package com.bnk.spring.springboot.spring_data_jpa.services;

import com.bnk.spring.springboot.spring_data_jpa.dao.EmployeeRepository;

import com.bnk.spring.springboot.spring_data_jpa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }



    public  void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }


    public Employee getEmployee(int id) {
        Employee employee = null;
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent())
            employee = optionalEmployee.get();
        return employee;
    }


    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee getEmployeeByName(String name) {
        return employeeRepository.findAllByName(name);
    }
}
