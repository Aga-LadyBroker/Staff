package com.agnieszkarut.central.employee.domain;

import com.agnieszkarut.foundation.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public class Employee extends BaseEntity {

    String firstName;
    String lastName;
    String pesel;
    String address;
    String email;
    String phone;
    LocalDate dateOfBirth;
    LocalDate dateOfEmployment;
    LocalDate dataOfDismissal;
    @Enumerated(EnumType.STRING)
    EmployeeJobType type;
    Long medicalUnitId;

    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn (name = "employee_id")
    List<EmployeeSkill> employeeSkills;

    public Employee() {this.employeeSkills = new ArrayList<>();
    }
}
