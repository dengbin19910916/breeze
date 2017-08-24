package com.geek.apply.site.apply.formal.person;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Person {

    private String customerName;
    private String mobileNumber;
    private LocalDate birthDate;
}
