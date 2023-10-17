package com.agnieszkarut.central.medicalunit.domain;

import com.agnieszkarut.foundation.domain.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedicalUnitService implements AbstractService<MedicalUnit> {

private final MedicalUnitRepository repository;

@Override
public JpaRepository<MedicalUnit, Long> getRepository() { return repository;
        }
@Override
public JpaSpecificationExecutor <MedicalUnit> getSpecificationExecutor() {
        return repository;
        }
}

