package com.aln.esceulamusicabackend.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")
    public String index() {
        return "Hi by:Apologix ";
    }

    @GetMapping("/error")
    public String error() {
        return "An error occurred by:Apologix ";
    }
}
