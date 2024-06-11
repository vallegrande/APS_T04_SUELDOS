package pe.edu.vallegrande.sueldos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.sueldos.exception.ResourceNotFoundException;
import pe.edu.vallegrande.sueldos.model.entity.Employee;
import pe.edu.vallegrande.sueldos.repository.EmployeeRepository;
import pe.edu.vallegrande.sueldos.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        employee.setActive('A');
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(int id, Employee updatedEmployee) {
        return employeeRepository.findById(id).map(existingEmployee -> {
            Optional.ofNullable(updatedEmployee.getName()).ifPresent(existingEmployee::setName);
            Optional.ofNullable(updatedEmployee.getLastName()).ifPresent(existingEmployee::setLastName);
            Optional.ofNullable(updatedEmployee.getDni()).ifPresent(existingEmployee::setDni);
            Optional.ofNullable(updatedEmployee.getBirthDate()).ifPresent(existingEmployee::setBirthDate);
            Optional.ofNullable(updatedEmployee.getAddress()).ifPresent(existingEmployee::setAddress);
            Optional.ofNullable(updatedEmployee.getPhone()).ifPresent(existingEmployee::setPhone);
            Optional.ofNullable(updatedEmployee.getEmail()).ifPresent(existingEmployee::setEmail);
            Optional.ofNullable(updatedEmployee.getHireDate()).ifPresent(existingEmployee::setHireDate);
            Optional.ofNullable(updatedEmployee.getDepartment()).ifPresent(existingEmployee::setDepartment);
            Optional.ofNullable(updatedEmployee.getPosition()).ifPresent(existingEmployee::setPosition);
            Optional.ofNullable(updatedEmployee.getContractType()).ifPresent(existingEmployee::setContractType);
            return employeeRepository.save(existingEmployee);
        }).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));
    }


    @Override
    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        if (employees.isEmpty()) {
            throw new ResourceNotFoundException("No employees found");
        }
        return employees;
    }

    @Override
    public List<Employee> getActiveEmployees() {
        List<Employee> activeEmployees = employeeRepository.findByActive('A');
        if (activeEmployees.isEmpty()) {
            throw new ResourceNotFoundException("No active employees found");
        }
        return activeEmployees;
    }

    @Override
    public List<Employee> getInactiveEmployees() {
        List<Employee> inactiveEmployees = employeeRepository.findByActive('I');
        if (inactiveEmployees.isEmpty()) {
            throw new ResourceNotFoundException("No inactive employees found");
        }
        return inactiveEmployees;
    }

    @Override
    public void inactiveEmployee(int id) {
        Employee employees = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));
        employees.setActive('I');
        employeeRepository.save(employees);
    }

    @Override
    public void activeEmployee(int id) {
        Employee employees = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));
        employees.setActive('A');
        employeeRepository.save(employees);
    }
}
