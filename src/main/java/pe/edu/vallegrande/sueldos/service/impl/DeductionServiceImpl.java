package pe.edu.vallegrande.sueldos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.sueldos.exception.ResourceNotFoundException;
import pe.edu.vallegrande.sueldos.model.entity.Deduction;
import pe.edu.vallegrande.sueldos.repository.DeductionRepository;
import pe.edu.vallegrande.sueldos.service.DeductionService;

import java.util.List;

@Service
public class DeductionServiceImpl implements DeductionService {

    @Autowired
    private DeductionRepository deductionRepository;


    @Override
    public List<Deduction> getAllDeductions() {
        List<Deduction> deductions = deductionRepository.findAll();
        if (deductions.isEmpty()) {
            throw new ResourceNotFoundException("No deductions found");
        }
        return deductions;
    }
}