package com.agnieszkarut.central.medicalunit.domain;

import com.agnieszkarut.foundation.domain.AbstractFactory;
import org.springframework.stereotype.Component;
@Component
public class MedicalUnitFactory implements AbstractFactory<MedicalUnit> {
@Override
public MedicalUnit create() {
        return new MedicalUnit();}
}
