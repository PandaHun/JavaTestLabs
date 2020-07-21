package com.pandahun.repository;

import com.pandahun.domain.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository

public interface TestRepository extends JpaRepository<Test, Long> {

}