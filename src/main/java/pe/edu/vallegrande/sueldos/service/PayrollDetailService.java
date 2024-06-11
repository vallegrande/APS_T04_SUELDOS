package pe.edu.vallegrande.sueldos.service;


import pe.edu.vallegrande.sueldos.model.entity.PayrollDetail;

import java.util.List;

public interface PayrollDetailService {

    PayrollDetail createPayrollDetail(PayrollDetail payrollDetail);

    PayrollDetail updatePayrollDetail(int id, PayrollDetail payrollDetail);

    PayrollDetail getPayrollDetailById(int id);

    List<PayrollDetail> getAllPayrollDetails();

    List<PayrollDetail> getActivePayrollDetails();

    List<PayrollDetail> getInactivePayrollDetails();

    void inactivePayrollDetail(int id);

    void activePayrollDetail(int id);
}
