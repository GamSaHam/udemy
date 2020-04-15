package com.luv2code.springdemo.config.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentErrorResponse {

    private int status;
    private String message;
    private long timeStmap;

    
}
