package pe.edu.vallegrande.sueldos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.vallegrande.sueldos.model.entity.Payroll;

public interface PayrollRepository extends JpaRepository<Payroll, Integer> {
}
