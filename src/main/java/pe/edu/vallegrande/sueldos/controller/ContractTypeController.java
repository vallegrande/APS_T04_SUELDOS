package pe.edu.vallegrande.sueldos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.vallegrande.sueldos.model.entity.ContractType;
import pe.edu.vallegrande.sueldos.service.ContractTypeService;


import java.util.List;

@RestController
@RequestMapping("/contract-types")
public class ContractTypeController {

    @Autowired
    private ContractTypeService contractTypeService;

    @GetMapping
    public List<ContractType> getAllContractTypes() {
        return contractTypeService.getAllContractTypes();
    }
}
