package pe.edu.vallegrande.sueldos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.vallegrande.sueldos.model.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
