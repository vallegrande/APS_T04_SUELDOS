package vallegrande.edu.pe.vg_ms_salary.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vallegrande.edu.pe.vg_ms_salary.model.Payroll;
import vallegrande.edu.pe.vg_ms_salary.repository.PayrollRepository;
import vallegrande.edu.pe.vg_ms_salary.service.PayrollService;

import java.util.List;
import java.util.Optional;

@Service
public class PayrollServiceImpl implements PayrollService {

    @Autowired
    private PayrollRepository payrollRepository;

    @Override
    public List<Payroll> getAllPayrolls() {
        return payrollRepository.findAll();
    }

    @Override
    public Optional<Payroll> getPayrollById(Long id) {
        return payrollRepository.findById(id);
    }

    @Override
    public Payroll savePayroll(Payroll payroll) {
        return payrollRepository.save(payroll);
    }

    @Override
    public Optional<Payroll> updatePayroll(Long id, Payroll payrollDetails) {
        return payrollRepository.findById(id).map(payroll -> {
            payroll.setPeriod(payrollDetails.getPeriod());
            payroll.setGenerationDate(payrollDetails.getGenerationDate());
            return payrollRepository.save(payroll);
        });
    }

    @Override
    public boolean deletePayroll(Long id) {
        return payrollRepository.findById(id).map(payroll -> {
            payrollRepository.delete(payroll);
            return true;
        }).orElse(false);
    }
}