package vallegrande.edu.pe.vg_ms_salary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vallegrande.edu.pe.vg_ms_salary.model.Department;
import vallegrande.edu.pe.vg_ms_salary.service.DepartmentService;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<Department> findAll() {
        return departmentService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> findById(@PathVariable Long id) {
        Department department = departmentService.findById(id);
        if (department != null) {
            return ResponseEntity.ok(department);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Department save(@RequestBody Department department) {
        return departmentService.save(department);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> update(@PathVariable Long id, @RequestBody Department department) {
        if (departmentService.findById(id) != null) {
            department.setId(id);
            return ResponseEntity.ok(departmentService.save(department));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        if (departmentService.findById(id) != null) {
            departmentService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}