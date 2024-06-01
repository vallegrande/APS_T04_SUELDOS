package vallegrande.edu.pe.vg_ms_salary.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vallegrande.edu.pe.vg_ms_salary.model.Department;
import vallegrande.edu.pe.vg_ms_salary.repository.DepartmentRepository;
import vallegrande.edu.pe.vg_ms_salary.service.DepartmentService;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @Override
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public void deleteById(Long id) {
        departmentRepository.deleteById(id);
    }
}