package pe.edu.vallegrande.sueldos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.sueldos.model.entity.Employee;
import pe.edu.vallegrande.sueldos.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/active")
    public List<Employee> getActiveEmployees() {
        return employeeService.getActiveEmployees();
    }

    @GetMapping("/inactive")
    public List<Employee> getInactiveEmployees() {
        return employeeService.getInactiveEmployees();
    }

    @DeleteMapping("/inactive/{id}")
    public ResponseEntity<Void> inactiveEmployee(@PathVariable int id) {
        employeeService.inactiveEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/active/{id}")
    public ResponseEntity<Void> activeEmployee(@PathVariable int id) {
        employeeService.activeEmployee(id);
        return ResponseEntity.noContent().build();
    }

}