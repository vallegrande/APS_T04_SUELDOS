package vallegrande.edu.pe.vg_ms_salary.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vallegrande.edu.pe.vg_ms_salary.model.Employee;
import vallegrande.edu.pe.vg_ms_salary.repository.EmployeeRepository;
import vallegrande.edu.pe.vg_ms_salary.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> updateEmployee(Long id, Employee employeeDetails) {
        return employeeRepository.findById(id).map(employee -> {
            employee.setFirstName(employeeDetails.getFirstName());
            employee.setLastName(employeeDetails.getLastName());
            employee.setDni(employeeDetails.getDni());
            employee.setBirthDate(employeeDetails.getBirthDate());
            employee.setAddress(employeeDetails.getAddress());
            employee.setPhone(employeeDetails.getPhone());
            employee.setEmail(employeeDetails.getEmail());
            employee.setHireDate(employeeDetails.getHireDate());
            employee.setDepartment(employeeDetails.getDepartment());
            employee.setPosition(employeeDetails.getPosition());
            employee.setContractType(employeeDetails.getContractType());
            return employeeRepository.save(employee);
        });
    }

    @Override
    public boolean deleteEmployee(Long id) {
        return employeeRepository.findById(id).map(employee -> {
            employeeRepository.delete(employee);
            return true;
        }).orElse(false);
    }
}