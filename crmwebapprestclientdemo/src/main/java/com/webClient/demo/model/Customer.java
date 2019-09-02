package com.webClient.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Customer {

    private int id;

    private String firstName;

    private String lastName;

    private String email;
}