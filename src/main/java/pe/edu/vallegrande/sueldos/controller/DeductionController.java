package pe.edu.vallegrande.sueldos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.vallegrande.sueldos.model.entity.Deduction;
import pe.edu.vallegrande.sueldos.service.DeductionService;

import java.util.List;

@RestController
@RequestMapping("/deductions")
public class DeductionController {

    @Autowired
    private DeductionService deductionService;

    @GetMapping
    public List<Deduction> getAllDeductions() {
        return deductionService.getAllDeductions();
    }
}
