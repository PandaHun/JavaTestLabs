package com.pandahun.ibm.test.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TestingRepo extends CrudRepository<Testing, Integer> {

    List<Testing> findAll();
}
