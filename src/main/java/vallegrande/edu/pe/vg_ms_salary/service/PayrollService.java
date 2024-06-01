package vallegrande.edu.pe.vg_ms_salary.service;

import vallegrande.edu.pe.vg_ms_salary.model.Payroll;

import java.util.List;
import java.util.Optional;

public interface PayrollService {
    List<Payroll> getAllPayrolls();
    Optional<Payroll> getPayrollById(Long id);
    Payroll savePayroll(Payroll payroll);
    Optional<Payroll> updatePayroll(Long id, Payroll payrollDetails);
    boolean deletePayroll(Long id);
}