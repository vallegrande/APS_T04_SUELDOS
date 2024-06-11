package pe.edu.vallegrande.sueldos.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "contract_type")
@Data
public class ContractType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "description")
    private String description;
}
