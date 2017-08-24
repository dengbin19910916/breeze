package com.geek.ui.site.apply.formal.person;

import com.geek.apply.site.apply.formal.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/apply")
public class PersonController {

    private final RestTemplate restTemplate;

    @Autowired
    public PersonController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/person")
    public String index(Model model) {
        Person person = restTemplate.getForObject("http://BREEZE-APPLY/apply/person", Person.class);
        System.err.println(person);
        model.addAttribute(person != null ? person : new Person());
        return "person";
    }
}
