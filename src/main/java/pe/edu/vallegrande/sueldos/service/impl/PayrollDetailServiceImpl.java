package pe.edu.vallegrande.sueldos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.sueldos.exception.ResourceNotFoundException;
import pe.edu.vallegrande.sueldos.model.entity.PayrollDetail;
import pe.edu.vallegrande.sueldos.repository.PayrollDetailRepository;
import pe.edu.vallegrande.sueldos.service.PayrollDetailService;

import java.util.List;
import java.util.Optional;

@Service
public class PayrollDetailServiceImpl implements PayrollDetailService {

    @Autowired
    private PayrollDetailRepository payrollDetailRepository;

    @Override
    public PayrollDetail createPayrollDetail(PayrollDetail payrollDetail) {
        payrollDetail.setActive('A');
        return payrollDetailRepository.save(payrollDetail);
    }

    @Override
    public PayrollDetail updatePayrollDetail(int id, PayrollDetail updatedPayrollDetail) {
        return payrollDetailRepository.findById(id).map(existingPayrollDetail -> {
            Optional.ofNullable(updatedPayrollDetail.getPayroll()).ifPresent(existingPayrollDetail::setPayroll);
            Optional.ofNullable(updatedPayrollDetail.getEmployee()).ifPresent(existingPayrollDetail::setEmployee);
            Optional.ofNullable(updatedPayrollDetail.getBonus()).ifPresent(existingPayrollDetail::setBonus);
            Optional.ofNullable(updatedPayrollDetail.getDeduction()).ifPresent(existingPayrollDetail::setDeduction);
            Optional.ofNullable(updatedPayrollDetail.getGrossSalary()).ifPresent(existingPayrollDetail::setGrossSalary);
            Optional.ofNullable(updatedPayrollDetail.getNetSalary()).ifPresent(existingPayrollDetail::setNetSalary);
            Optional.ofNullable(updatedPayrollDetail.getPaymentDate()).ifPresent(existingPayrollDetail::setPaymentDate);
            return payrollDetailRepository.save(existingPayrollDetail);
        }).orElseThrow(() -> new ResourceNotFoundException("Payroll Detail not found with id " + id));
    }

    @Override
    public PayrollDetail getPayrollDetailById(int id) {
        return payrollDetailRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payroll Detail not found with id " + id));
    }

    @Override
    public List<PayrollDetail> getAllPayrollDetails() {
        List<PayrollDetail> payrollDetails = payrollDetailRepository.findAll();
        if (payrollDetails.isEmpty()) {
            throw new ResourceNotFoundException("No Payroll Detail found");
        }
        return payrollDetails;
    }

    @Override
    public List<PayrollDetail> getActivePayrollDetails() {
        List<PayrollDetail> activePayrollDetails = payrollDetailRepository.findByActive('A');
        if (activePayrollDetails.isEmpty()) {
            throw new ResourceNotFoundException("No active Payroll Detail found");
        }
        return activePayrollDetails;
    }

    @Override
    public List<PayrollDetail> getInactivePayrollDetails() {
        List<PayrollDetail> inactivePayrollDetails = payrollDetailRepository.findByActive('I');
        if (inactivePayrollDetails.isEmpty()) {
            throw new ResourceNotFoundException("No inactive Payroll Detail found");
        }
        return inactivePayrollDetails;
    }

    @Override
    public void inactivePayrollDetail(int id) {
        PayrollDetail payrollDetails = payrollDetailRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));
        payrollDetails.setActive('I');
        payrollDetailRepository.save(payrollDetails);
    }

    @Override
    public void activePayrollDetail(int id) {
        PayrollDetail payrollDetails = payrollDetailRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payroll Detail not found with id " + id));
        payrollDetails.setActive('A');
        payrollDetailRepository.save(payrollDetails);
    }
}
