package com.agnieszkarut.central.employee.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {
    @Query(value = "select e from Employee e " +
            "where (:medicalUnitId is null or e.medicalUnitId = :medicalUnitId) and (:type is null or e.type = :type)")
    List<Employee> findByCriteria (@Param("medicalUnitId") Long medicalUnitId, @Param("type") EmployeeJobType type);
}
