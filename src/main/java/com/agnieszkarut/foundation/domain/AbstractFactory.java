package com.agnieszkarut.foundation.domain;

public interface AbstractFactory < E extends BaseEntity>{
     E create();
}
