package pe.edu.vallegrande.sueldos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.vallegrande.sueldos.model.entity.Position;

public interface PositionRepository extends JpaRepository<Position, Integer> {
}
