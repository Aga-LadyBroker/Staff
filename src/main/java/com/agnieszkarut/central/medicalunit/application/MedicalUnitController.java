package com.agnieszkarut.central.medicalunit.application;

import com.agnieszkarut.central.medicalunit.domain.MedicalUnit;
import com.agnieszkarut.central.medicalunit.domain.MedicalUnitRepository;
import com.agnieszkarut.central.medicalunit.domain.MedicalUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/central/medical-units")
public class MedicalUnitController {
    @Autowired
    MedicalUnitRepository repository;
    @Autowired
    MedicalUnitService service;

    @GetMapping
    public ResponseEntity <List<MedicalUnit>> getMany(
            @RequestParam(value = "address.city", required = false) String city,
            @RequestParam(value = "parentMedicalUnitId", required = false) Long parentMedicalUnitId) {
        return ResponseEntity.ok(repository.findByCriteria(city, parentMedicalUnitId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalUnit> getOne(@PathVariable("id") Long id) {

        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MedicalUnit> addNew(@RequestBody MedicalUnit medicalUnit) {
        return ResponseEntity.created(null).body(service.add(medicalUnit));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MedicalUnit> remove(@PathVariable("id") Long id) {

        Optional<MedicalUnit> medicalUnit = repository.findById(id);

        if (!medicalUnit.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return ResponseEntity.ok(medicalUnit.get());
    }
}
