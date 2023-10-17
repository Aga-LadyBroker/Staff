package com.agnieszkarut.central.employee.application;

import com.agnieszkarut.central.employee.domain.Employee;
import com.agnieszkarut.central.employee.domain.EmployeeJobType;
import com.agnieszkarut.central.employee.domain.EmployeeRepository;
import com.agnieszkarut.central.employee.domain.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/central/employees")

public class EmployeeController {
    @Autowired
    EmployeeRepository repository;

    @Autowired
    EmployeeService service;

    @GetMapping
    public ResponseEntity<List<Employee>> getMany(
            @RequestParam(value = "medicalUnitId", required = false) Long medicalUnitId,
            @RequestParam(value = "type", required = false) EmployeeJobType type) {
        return ResponseEntity.ok(repository.findByCriteria(medicalUnitId, type));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getOne(@PathVariable("id") Long id) {

        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Employee> addNew(@RequestBody Employee employee) {
        return ResponseEntity.created(null).body(service.add(employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> remove(@PathVariable("id") Long id) {

        Optional<Employee> employee = repository.findById(id);

        if (!employee.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return ResponseEntity.ok(employee.get());
    }
}
