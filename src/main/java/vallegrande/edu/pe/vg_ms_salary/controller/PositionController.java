package vallegrande.edu.pe.vg_ms_salary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vallegrande.edu.pe.vg_ms_salary.model.Position;
import vallegrande.edu.pe.vg_ms_salary.service.PositionService;

import java.util.List;

@RestController
@RequestMapping("/api/positions")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @GetMapping
    public List<Position> getAllPositions() {
        return positionService.getAllPositions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Position> getPositionById(@PathVariable Long id) {
        return positionService.getPositionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Position createPosition(@RequestBody Position position) {
        return positionService.savePosition(position);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Position> updatePosition(@PathVariable Long id, @RequestBody Position position) {
        return positionService.updatePosition(id, position)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePosition(@PathVariable Long id) {
        if (positionService.deletePosition(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}