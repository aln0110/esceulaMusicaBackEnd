package com.aln.esceulamusicabackend.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

     @RequestMapping("/")
    public String index() {
        return "Welcome to the Escuelamusicabackend API!";
    }

    @RequestMapping("/error")
    public String error() {
        return "An error occurred. Please try again later.";
    }

}
