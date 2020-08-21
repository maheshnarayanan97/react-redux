package com.react.reactspring.controller;

import com.react.reactspring.model.Employee;
import com.react.reactspring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/api")
@CrossOrigin(origins="http://localhost:3000")
public class  EmployeeController {

    @Autowired
    EmployeeService employeeService;



    @PostMapping("/save")
    public Employee save(@RequestBody Employee employee){
        employeeService.saveorupdate((employee));
        return employee;
    }

    @GetMapping("/list")
    public List<Employee> list(){
        return employeeService.getAllEmployee();

    }
    @GetMapping("/list/{id}")
    public Employee getbyId(@PathVariable Long id){
        return employeeService.getByid(id);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable (value = "id") Long id){
        employeeService.deleteEmployee(id);
        return "delete successfully"+id;
    }
    @PutMapping("/save")
    public Employee updateCourse( @RequestBody Employee employee){
        employeeService.updateEmployee(employee);
        return employee;

    }
}

