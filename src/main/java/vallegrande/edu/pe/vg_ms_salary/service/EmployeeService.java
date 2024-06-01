package vallegrande.edu.pe.vg_ms_salary.service;

import vallegrande.edu.pe.vg_ms_salary.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Optional<Employee> getEmployeeById(Long id);
    Employee saveEmployee(Employee employee);
    Optional<Employee> updateEmployee(Long id, Employee employeeDetails);
    boolean deleteEmployee(Long id);
}