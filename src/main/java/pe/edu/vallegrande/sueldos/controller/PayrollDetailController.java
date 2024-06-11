package pe.edu.vallegrande.sueldos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.sueldos.model.entity.PayrollDetail;
import pe.edu.vallegrande.sueldos.service.PayrollDetailService;

import java.util.List;

@RestController
@RequestMapping("/payroll-details")
public class PayrollDetailController {

    @Autowired
    private PayrollDetailService payrollDetailService;

    @PostMapping
    public PayrollDetail createPayrollDetail(@RequestBody PayrollDetail payrollDetail) {
        return payrollDetailService.createPayrollDetail(payrollDetail);
    }

    @PutMapping("/{id}")
    public PayrollDetail updatePayrollDetail(@PathVariable int id, @RequestBody PayrollDetail payrollDetail) {
        return payrollDetailService.updatePayrollDetail(id, payrollDetail);
    }

    @GetMapping("/{id}")
    public PayrollDetail getPayrollDetailById(@PathVariable int id) {
        return payrollDetailService.getPayrollDetailById(id);
    }

    @GetMapping
    public List<PayrollDetail> getAllPayrollDetails() {
        return payrollDetailService.getAllPayrollDetails();
    }

    @GetMapping("/active")
    public List<PayrollDetail> getActivePayrollDetails() {
        return payrollDetailService.getActivePayrollDetails();
    }

    @GetMapping("/inactive")
    public List<PayrollDetail> getInactivePayrollDetails() {
        return payrollDetailService.getInactivePayrollDetails();
    }

    @DeleteMapping("/inactive/{id}")
    public ResponseEntity<Void> inactiveEmployee(@PathVariable int id) {
        payrollDetailService.inactivePayrollDetail(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/active/{id}")
    public ResponseEntity<Void> activeEmployee(@PathVariable int id) {
        payrollDetailService.activePayrollDetail(id);
        return ResponseEntity.noContent().build();
    }
}
