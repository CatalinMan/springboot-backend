package net.javaguides.springbootbackend.service;

import net.javaguides.springbootbackend.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Optional<Employee> getEmployeeById(long id);

    Employee updateEmployee(Employee employee, long id);

    //    Employee deleteEmployeeById(long id);
    void deleteEmployeeById(long id);
}
