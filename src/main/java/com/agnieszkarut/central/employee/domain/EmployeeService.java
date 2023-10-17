package com.agnieszkarut.central.employee.domain;

import com.agnieszkarut.foundation.domain.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService implements AbstractService<Employee> {
    private final EmployeeRepository repository;

    @Override
    public JpaRepository <Employee, Long> getRepository() { return repository;
    }

    @Override
    public JpaSpecificationExecutor<Employee> getSpecificationExecutor() {
        return repository;
    }
}
