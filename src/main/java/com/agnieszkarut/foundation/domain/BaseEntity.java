package com.agnieszkarut.foundation.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
@Data
@EqualsAndHashCode (of = "id")
public abstract class BaseEntity {

    @Id
    @GeneratedValue
    protected Long id;

    @Version
    protected int version;
}
