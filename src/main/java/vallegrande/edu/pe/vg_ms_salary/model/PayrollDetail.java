package vallegrande.edu.pe.vg_ms_salary.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class PayrollDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "payroll_id")
    private Payroll payroll;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private Double grossSalary;
    private Double deductions;
    private Double netSalary;
    private Double bonuses;
    private Date paymentDate;
}