package vallegrande.edu.pe.vg_ms_salary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vallegrande.edu.pe.vg_ms_salary.model.Payroll;
import vallegrande.edu.pe.vg_ms_salary.service.PayrollService;

import java.util.List;

@RestController
@RequestMapping("/api/payrolls")
public class PayrollController {

    @Autowired
    private PayrollService payrollService;

    @GetMapping
    public List<Payroll> getAllPayrolls() {
        return payrollService.getAllPayrolls();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payroll> getPayrollById(@PathVariable Long id) {
        return payrollService.getPayrollById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Payroll createPayroll(@RequestBody Payroll payroll) {
        return payrollService.savePayroll(payroll);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payroll> updatePayroll(@PathVariable Long id, @RequestBody Payroll payroll) {
        return payrollService.updatePayroll(id, payroll)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayroll(@PathVariable Long id) {
        if (payrollService.deletePayroll(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}