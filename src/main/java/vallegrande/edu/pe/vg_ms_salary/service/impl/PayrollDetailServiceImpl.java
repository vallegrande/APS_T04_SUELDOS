package vallegrande.edu.pe.vg_ms_salary.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vallegrande.edu.pe.vg_ms_salary.model.PayrollDetail;
import vallegrande.edu.pe.vg_ms_salary.repository.PayrollDetailRepository;
import vallegrande.edu.pe.vg_ms_salary.service.PayrollDetailService;

import java.util.List;
import java.util.Optional;

@Service
public class PayrollDetailServiceImpl implements PayrollDetailService {

    @Autowired
    private PayrollDetailRepository payrollDetailRepository;

    @Override
    public List<PayrollDetail> getAllPayrollDetails() {
        return payrollDetailRepository.findAll();
    }

    @Override
    public Optional<PayrollDetail> getPayrollDetailById(Long id) {
        return payrollDetailRepository.findById(id);
    }

    @Override
    public PayrollDetail savePayrollDetail(PayrollDetail payrollDetail) {
        return payrollDetailRepository.save(payrollDetail);
    }

    @Override
    public Optional<PayrollDetail> updatePayrollDetail(Long id, PayrollDetail payrollDetails) {
        return payrollDetailRepository.findById(id).map(payrollDetail -> {
            payrollDetail.setPayroll(payrollDetails.getPayroll());
            payrollDetail.setEmployee(payrollDetails.getEmployee());
            payrollDetail.setGrossSalary(payrollDetails.getGrossSalary());
            payrollDetail.setDeductions(payrollDetails.getDeductions());
            payrollDetail.setNetSalary(payrollDetails.getNetSalary());
            payrollDetail.setBonuses(payrollDetails.getBonuses());
            payrollDetail.setPaymentDate(payrollDetails.getPaymentDate());
            return payrollDetailRepository.save(payrollDetails);
        });
    }

    @Override
    public boolean deletePayrollDetail(Long id) {
        return payrollDetailRepository.findById(id).map(payrollDetail -> {
            payrollDetailRepository.delete(payrollDetail);
            return true;
        }).orElse(false);
    }
}
