package com.pandahun.ibm.test.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Testing {

    @Id
    private Integer idx;

    private String name;

    @Override
    public String toString() {
        return String.format("%d: %s\n", idx, name);
    }
}
