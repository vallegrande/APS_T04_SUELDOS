package vallegrande.edu.pe.vg_ms_salary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vallegrande.edu.pe.vg_ms_salary.model.PayrollDetail;

public interface PayrollDetailRepository extends JpaRepository<PayrollDetail, Long> {}