package com.agnieszkarut.central.employee.domain;

import com.agnieszkarut.foundation.domain.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public class EmployeeSkill extends BaseEntity {
    Long skillId;
    String name;

}
