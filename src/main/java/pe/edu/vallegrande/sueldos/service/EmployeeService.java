package pe.edu.vallegrande.sueldos.service;

import pe.edu.vallegrande.sueldos.model.entity.Employee;

import java.util.List;

public interface EmployeeService {
	Employee createEmployee(Employee employee);

	Employee updateEmployee(int id, Employee employee);

	Employee getEmployeeById(int id);

	List<Employee> getAllEmployees();

	List<Employee> getActiveEmployees();

	List<Employee> getInactiveEmployees();

	void inactiveEmployee(int id);

	void activeEmployee(int id);
}