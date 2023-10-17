package com.agnieszkarut.central.medicalunit.domain;

import com.agnieszkarut.foundation.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public class MedicalUnit extends BaseEntity {

    String medicalUnitName;
    MedicalUnitAddress address;
    @Enumerated(EnumType.STRING)
    MedicalUnitTypeOfActivity activity;
    Long parentMedicalUnitId;
}
