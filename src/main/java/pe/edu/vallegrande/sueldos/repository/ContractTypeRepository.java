package pe.edu.vallegrande.sueldos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.vallegrande.sueldos.model.entity.ContractType;

public interface ContractTypeRepository extends JpaRepository<ContractType, Integer> {
}
