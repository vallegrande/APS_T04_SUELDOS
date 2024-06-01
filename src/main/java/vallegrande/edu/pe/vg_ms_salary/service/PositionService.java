package vallegrande.edu.pe.vg_ms_salary.service;

import vallegrande.edu.pe.vg_ms_salary.model.Position;

import java.util.List;
import java.util.Optional;

public interface PositionService {
    List<Position> getAllPositions();
    Optional<Position> getPositionById(Long id);
    Position savePosition(Position position);
    Optional<Position> updatePosition(Long id, Position positionDetails);
    boolean deletePosition(Long id);
}