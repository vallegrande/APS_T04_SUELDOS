package pe.edu.vallegrande.sueldos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.vallegrande.sueldos.model.entity.Deduction;

public interface DeductionRepository extends JpaRepository<Deduction, Integer> {
}
