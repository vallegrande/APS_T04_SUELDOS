package pe.edu.vallegrande.sueldos.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "deduction")
@Data
public class Deduction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "amount")
    private String amount;
}
