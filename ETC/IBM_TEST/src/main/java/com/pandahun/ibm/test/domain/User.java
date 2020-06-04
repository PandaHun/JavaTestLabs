package com.pandahun.ibm.test.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private Long id;
    private String name;
    private String email;
    private String contact;
    private String password;

    @Override
    public String toString() {
        return String.format("user id is %d and name is %s", id, name);
    }
}