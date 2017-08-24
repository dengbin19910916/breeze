package com.geek.apply.site.apply.formal.person;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/apply")
public class PersonController {

    @GetMapping("/person")
    public Person getPerson() {
        Person person = new Person();
        person.setCustomerName("邓斌");
        person.setMobileNumber("14789511370");
        person.setBirthDate(LocalDate.parse("1991-11-23"));
        return person;
    }
}
