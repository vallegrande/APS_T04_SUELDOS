package pe.edu.vallegrande.sueldos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.sueldos.exception.ResourceNotFoundException;
import pe.edu.vallegrande.sueldos.model.entity.Position;
import pe.edu.vallegrande.sueldos.repository.PositionRepository;
import pe.edu.vallegrande.sueldos.service.PositionService;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionRepository positionRepository;

    @Override
    public List<Position> getAllPositions() {
        List<Position> positions = positionRepository.findAll();
        if (positions.isEmpty()) {
            throw new ResourceNotFoundException("No positions found");
        }
        return positions;
    }
}
