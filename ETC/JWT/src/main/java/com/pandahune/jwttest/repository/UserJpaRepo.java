package com.pandahune.jwttest.repository;

import com.pandahune.jwttest.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserJpaRepo extends JpaRepository<User, Integer> {

    Optional<User> findByName(String email);
}
