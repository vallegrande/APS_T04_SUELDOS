package pe.edu.vallegrande.sueldos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.sueldos.exception.ResourceNotFoundException;
import pe.edu.vallegrande.sueldos.model.entity.ContractType;
import pe.edu.vallegrande.sueldos.repository.ContractTypeRepository;
import pe.edu.vallegrande.sueldos.service.ContractTypeService;

import java.util.List;

@Service
public class ContractTypeServiceImpl implements ContractTypeService {

    @Autowired
    private ContractTypeRepository contractTypeRepository;

    @Override
    public List<ContractType> getAllContractTypes() {
        List<ContractType> contractTypes = contractTypeRepository.findAll();
        if (contractTypes.isEmpty()) {
            throw new ResourceNotFoundException("No contractTypes found");
        }
        return contractTypes;
    }
}
