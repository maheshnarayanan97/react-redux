package com.react.reactspring.repository;

import com.react.reactspring.model.Employee;
import org.springframework.data.repository.CrudRepository;
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
