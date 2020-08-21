package com.react.reactspring.service;

import com.react.reactspring.model.Employee;

import java.util.List;
public interface EmployeeService {
    public List<Employee> getAllEmployee();
    public Employee getByid(Long id);
    public void saveorupdate(Employee employee);
    public void deleteEmployee(Long id);
    void updateEmployee(Employee employee);
}
