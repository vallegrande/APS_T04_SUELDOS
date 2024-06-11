package pe.edu.vallegrande.sueldos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.vallegrande.sueldos.model.entity.Bonus;
import pe.edu.vallegrande.sueldos.model.entity.Department;
import pe.edu.vallegrande.sueldos.service.BonusService;
import pe.edu.vallegrande.sueldos.service.DepartmentService;

import java.util.List;

@RestController
@RequestMapping("/bonus")
public class BonusController {

    @Autowired
    private BonusService bonusService;

    @GetMapping
    public List<Bonus> getAllDepartments() {
        return bonusService.getAllBonuss();
    }
}
