package vallegrande.edu.pe.vg_ms_salary.service;

import vallegrande.edu.pe.vg_ms_salary.model.PayrollDetail;

import java.util.List;
import java.util.Optional;

public interface PayrollDetailService {
    List<PayrollDetail> getAllPayrollDetails();
    Optional<PayrollDetail> getPayrollDetailById(Long id);
    PayrollDetail savePayrollDetail(PayrollDetail payroll);
    Optional<PayrollDetail> updatePayrollDetail(Long id, PayrollDetail payrollDetails);
    boolean deletePayrollDetail(Long id);
}