package pe.edu.vallegrande.sueldos.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "payroll")
@Data

public class Payroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "period")
    private String period;

    @Column(name = "generation_date")
    private Date generationDate;
}
