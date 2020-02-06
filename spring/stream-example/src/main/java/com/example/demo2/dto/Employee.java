package com.example.demo2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
    private long id;
    private String name;
    private double salary;

    public void salaryIncrement(double percent) {
        this.salary = this.salary+this.salary/percent;
    }
}
