package com.react.reactspring.service;

import com.react.reactspring.model.Employee;

import com.react.reactspring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeRepository employeeRepository;


    @Override
    public List<Employee> getAllEmployee() {
        return (List<Employee>)employeeRepository.findAll();
    }

    @Override
    public Employee getByid(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public void saveorupdate(Employee employee) {
        employeeRepository.save(employee);

    }

    @Override
    public void updateEmployee(Employee employee) {
        Optional<Employee> empDb = this.employeeRepository.findById(employee.getId());
        if (empDb.isPresent()) {
            Employee courseUpdate = empDb.get();
            employee.setId(employee.getId());
            employee.setFirst_name(employee.getFirst_name());
            employee.setLast_name(employee.getLast_name());
            employee.setAddress(employee.getAddress());
            employee.setLanguage(employee.getLanguage());

            employeeRepository.save(employee);


        }
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
