package pe.edu.vallegrande.sueldos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.sueldos.exception.ResourceNotFoundException;
import pe.edu.vallegrande.sueldos.model.entity.Payroll;
import pe.edu.vallegrande.sueldos.repository.PayrollRepository;
import pe.edu.vallegrande.sueldos.service.PayrollService;

import java.util.List;

@Service
public class PayrollServiceImpl implements PayrollService {

    @Autowired
    private PayrollRepository payrollRepository;


    @Override
    public List<Payroll> getAllPayrolls() {
        List<Payroll> payrolls = payrollRepository.findAll();
        if (payrolls.isEmpty()) {
            throw new ResourceNotFoundException("No payrolls found");
        }
        return payrolls;
    }
}