package pe.edu.vallegrande.sueldos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.vallegrande.sueldos.model.entity.Bonus;

public interface BonusRepository extends JpaRepository<Bonus, Integer> {
}
