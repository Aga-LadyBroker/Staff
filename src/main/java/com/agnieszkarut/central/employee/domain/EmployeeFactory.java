package com.agnieszkarut.central.employee.domain;

import com.agnieszkarut.foundation.domain.AbstractFactory;
import org.springframework.stereotype.Component;

@Component
public class EmployeeFactory implements AbstractFactory<Employee> {
    @Override
    public Employee create() {
        return new Employee(); }
}

