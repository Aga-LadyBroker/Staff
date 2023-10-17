package com.agnieszkarut.central.medicalunit.domain;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class MedicalUnitAddress {
    String country;
    String postalCode;
    String city;
    String street;
    String buildingNumber;
}
