package net.javaguides.springbootbackend.controller;

import net.javaguides.springbootbackend.model.Employee;
import net.javaguides.springbootbackend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /*    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }*/

    /*    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees(); //don't put new anymore
    }*/

    //build create employee REST API
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.BAD_REQUEST);
    }

    //build get all employees REST API
    @GetMapping
    public ResponseEntity<List<Employee>> gellAllEmployees(){
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    //build get employee by id REST API
    // http://localhost:8080/api/employees/1
    @GetMapping("{id}")
    public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable(name = "id") long employeeId) {
        return new ResponseEntity<>(employeeService.getEmployeeById(employeeId), HttpStatus.FOUND);
    }

    //build upodate employee REST API
    // http://localhost:8080/api/employees/1
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id,
                                                   @RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
    }

    //build delete employee REST API
    // http://localhost:8080/api/employees/1
/*    @DeleteMapping("{id}")
    public ResponseEntity<Employee> deleteEmployeeById(@PathVariable long id) {
        return new ResponseEntity<>(employeeService.deleteEmployeeById(id), HttpStatus.OK);
    }*/

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable long id) {
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>("Employee with id "+ id + " was deleted.", HttpStatus.OK);
    }


}
