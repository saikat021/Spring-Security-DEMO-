package com.SpringSecurity.demosecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @GetMapping("/student")
    public String greetStudent(@RequestParam("name") String name){
        return "Hi Student"+name+" !!";
    }
    @PostMapping("/student")
    public String  greetStudent2(@RequestParam("name ") String name){
        return "Hi Student "+ name+" !!";
    }
    @GetMapping("/faculty")
    public String greetFaculty(@RequestParam("name") String name){
        return "Hi Faculty"+name+" !!";
    }
    @GetMapping("/")
    public String greetAll(@RequestParam("name") String name){
        return "Hi Public User:"+name;
    }

}
