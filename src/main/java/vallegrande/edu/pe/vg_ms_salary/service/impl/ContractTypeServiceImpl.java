package vallegrande.edu.pe.vg_ms_salary.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vallegrande.edu.pe.vg_ms_salary.model.ContractType;
import vallegrande.edu.pe.vg_ms_salary.repository.ContractTypeRepository;
import vallegrande.edu.pe.vg_ms_salary.service.ContractTypeService;

import java.util.List;
import java.util.Optional;

@Service
public class ContractTypeServiceImpl implements ContractTypeService {

    @Autowired
    private ContractTypeRepository contractTypeRepository;

    @Override
    public List<ContractType> getAllContractTypes() {
        return contractTypeRepository.findAll();
    }

    @Override
    public Optional<ContractType> getContractTypeById(Long id) {
        return contractTypeRepository.findById(id);
    }

    @Override
    public ContractType saveContractType(ContractType contractType) {
        return contractTypeRepository.save(contractType);
    }

    @Override
    public Optional<ContractType> updateContractType(Long id, ContractType contractTypeDetails) {
        return contractTypeRepository.findById(id).map(contractType -> {
            contractType.setDescription(contractTypeDetails.getDescription());
            contractType.setDescription(contractTypeDetails.getDescription());
            return contractTypeRepository.save(contractType);
        });
    }

    @Override
    public boolean deleteContractType(Long id) {
        return contractTypeRepository.findById(id).map(contractType -> {
            contractTypeRepository.delete(contractType);
            return true;
        }).orElse(false);
    }
}