package vallegrande.edu.pe.vg_ms_salary.service;

import vallegrande.edu.pe.vg_ms_salary.model.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> findAll();
    Department findById(Long id);
    Department save(Department department);
    void deleteById(Long id);
}