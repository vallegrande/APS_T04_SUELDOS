package pe.edu.vallegrande.sueldos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.sueldos.exception.ResourceNotFoundException;
import pe.edu.vallegrande.sueldos.model.entity.Bonus;
import pe.edu.vallegrande.sueldos.model.entity.Department;
import pe.edu.vallegrande.sueldos.repository.BonusRepository;
import pe.edu.vallegrande.sueldos.service.BonusService;

import java.util.List;

@Service
public class BonusServiceImpl implements BonusService {

    @Autowired
    private BonusRepository bonusRepository;

    @Override
    public List<Bonus> getAllBonuss() {
        List<Bonus> bonuss = bonusRepository.findAll();
        if (bonuss.isEmpty()) {
            throw new ResourceNotFoundException("No Bonus found");
        }
        return bonuss;
    }
}
