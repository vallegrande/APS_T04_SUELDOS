package vallegrande.edu.pe.vg_ms_salary.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vallegrande.edu.pe.vg_ms_salary.model.ContractType;
import vallegrande.edu.pe.vg_ms_salary.service.ContractTypeService;

import java.util.List;

@RestController
@RequestMapping("/api/contract-types")
public class ContractTypeController {

    @Autowired
    private ContractTypeService contractTypeService;

    @GetMapping
    public List<ContractType> getAllContractTypes() {
        return contractTypeService.getAllContractTypes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContractType> getContractTypeById(@PathVariable Long id) {
        return contractTypeService.getContractTypeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ContractType createContractType(@RequestBody ContractType contractType) {
        return contractTypeService.saveContractType(contractType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContractType> updateContractType(@PathVariable Long id, @RequestBody ContractType contractType) {
        return contractTypeService.updateContractType(id, contractType)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContractType(@PathVariable Long id) {
        if (contractTypeService.deleteContractType(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}