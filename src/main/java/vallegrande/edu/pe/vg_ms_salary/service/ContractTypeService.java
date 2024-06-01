package vallegrande.edu.pe.vg_ms_salary.service;

import vallegrande.edu.pe.vg_ms_salary.model.ContractType;

import java.util.List;
import java.util.Optional;

public interface ContractTypeService {
    List<ContractType> getAllContractTypes();
    Optional<ContractType> getContractTypeById(Long id);
    ContractType saveContractType(ContractType contractType);
    Optional<ContractType> updateContractType(Long id, ContractType contractTypeDetails);
    boolean deleteContractType(Long id);
}