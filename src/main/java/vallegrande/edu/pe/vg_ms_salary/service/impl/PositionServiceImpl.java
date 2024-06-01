package vallegrande.edu.pe.vg_ms_salary.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vallegrande.edu.pe.vg_ms_salary.model.Position;
import vallegrande.edu.pe.vg_ms_salary.repository.PositionRepository;
import vallegrande.edu.pe.vg_ms_salary.service.PositionService;

import java.util.List;
import java.util.Optional;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionRepository positionRepository;

    @Override
    public List<Position> getAllPositions() {
        return positionRepository.findAll();
    }

    @Override
    public Optional<Position> getPositionById(Long id) {
        return positionRepository.findById(id);
    }

    @Override
    public Position savePosition(Position position) {
        return positionRepository.save(position);
    }

    @Override
    public Optional<Position> updatePosition(Long id, Position positionDetails) {
        return positionRepository.findById(id).map(position -> {
            position.setName(positionDetails.getName());
            position.setDescription(positionDetails.getDescription());
            position.setBaseSalary(positionDetails.getBaseSalary());
            return positionRepository.save(position);
        });
    }

    @Override
    public boolean deletePosition(Long id) {
        return positionRepository.findById(id).map(position -> {
            positionRepository.delete(position);
            return true;
        }).orElse(false);
    }
}