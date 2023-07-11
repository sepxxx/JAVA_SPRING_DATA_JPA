package com.bnk.spring.springboot.spring_data_jpa.controller;
import com.bnk.spring.springboot.spring_data_jpa.entity.Employee;
import com.bnk.spring.springboot.spring_data_jpa.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id)   {
        Employee employee = employeeService.getEmployee(id);

        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id)   {
        Employee employee = employeeService.getEmployee(id);
        employeeService.deleteEmployee(id);
        return "Deleted id "+ id+ " from db";
    }

     @GetMapping("/employees/name/{name}")
    public Employee getEmployeeByName(@PathVariable String name) {
        return  employeeService.getEmployeeByName(name);
    }
}
