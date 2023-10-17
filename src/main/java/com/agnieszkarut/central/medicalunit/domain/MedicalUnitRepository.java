package com.agnieszkarut.central.medicalunit.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface MedicalUnitRepository extends JpaRepository<MedicalUnit, Long>, JpaSpecificationExecutor<MedicalUnit> {
@Query(value = "select mu from MedicalUnit mu " +
        "where (:city is null or mu.address.city = :city) and (:parentMedicalUnitId is null or mu.parentMedicalUnitId = :parentMedicalUnitId)")
    List<MedicalUnit> findByCriteria (@Param("city") String city, @Param("parentMedicalUnitId") Long parentMedicalUnitId);
        }

