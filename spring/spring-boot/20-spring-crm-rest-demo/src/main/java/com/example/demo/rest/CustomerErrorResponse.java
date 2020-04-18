package com.example.demo.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerErrorResponse {

    private int status;
    private String message;
    private long timeStamp;


}
