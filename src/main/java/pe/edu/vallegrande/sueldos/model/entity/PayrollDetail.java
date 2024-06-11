package pe.edu.vallegrande.sueldos.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "payroll_detail")
@Data
public class PayrollDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "payroll_id")
    private Payroll payroll;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "bonus_id")
    private Bonus bonus;

    @ManyToOne
    @JoinColumn(name = "deduction_id")
    private Deduction deduction;


    @Column(name = "gross_salary")
    private String grossSalary;

    @Column(name = "net_salary")
    private String netSalary;

    @Column(name = "payment_date")
    private Date paymentDate;

    @Column(name = "active")
    private char active;
}
