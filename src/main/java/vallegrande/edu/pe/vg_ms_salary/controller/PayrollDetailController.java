package vallegrande.edu.pe.vg_ms_salary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vallegrande.edu.pe.vg_ms_salary.model.PayrollDetail;
import vallegrande.edu.pe.vg_ms_salary.service.PayrollDetailService;

import java.util.List;

@RestController
@RequestMapping("/api/payroll-details")
public class PayrollDetailController {

    @Autowired
    private PayrollDetailService payrollDetailService;

    @GetMapping
    public List<PayrollDetail> getAllPayrollDetails() {
        return payrollDetailService.getAllPayrollDetails();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PayrollDetail> getPayrollDetailById(@PathVariable Long id) {
        return payrollDetailService.getPayrollDetailById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public PayrollDetail createPayrollDetail(@RequestBody PayrollDetail payrollDetail) {
        return payrollDetailService.savePayrollDetail(payrollDetail);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PayrollDetail> updatePayrollDetail(@PathVariable Long id, @RequestBody PayrollDetail payrollDetail) {
        return payrollDetailService.updatePayrollDetail(id, payrollDetail)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayrollDetail(@PathVariable Long id) {
        if (payrollDetailService.deletePayrollDetail(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}