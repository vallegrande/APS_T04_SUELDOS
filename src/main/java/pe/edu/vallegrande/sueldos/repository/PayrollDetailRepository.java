package pe.edu.vallegrande.sueldos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.vallegrande.sueldos.model.entity.PayrollDetail;

import java.util.List;

@Repository
public interface PayrollDetailRepository extends JpaRepository<PayrollDetail, Integer> {

    List<PayrollDetail> findByActive(char active);
}
