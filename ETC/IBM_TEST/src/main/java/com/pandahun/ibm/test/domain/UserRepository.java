package com.pandahun.ibm.test.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByName(String name);
    Iterable<User> findAll();
}
