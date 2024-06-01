package vallegrande.edu.pe.vg_ms_salary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vallegrande.edu.pe.vg_ms_salary.model.Payroll;

public interface PayrollRepository extends JpaRepository<Payroll, Long> {}