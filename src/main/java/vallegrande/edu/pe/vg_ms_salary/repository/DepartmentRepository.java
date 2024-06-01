package vallegrande.edu.pe.vg_ms_salary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vallegrande.edu.pe.vg_ms_salary.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {}
