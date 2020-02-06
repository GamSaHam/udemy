package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
    private long id;
    private String name;
    private double salary;

    public void salaryIncrement(double salary) {
        this.salary += salary;
    }
}
