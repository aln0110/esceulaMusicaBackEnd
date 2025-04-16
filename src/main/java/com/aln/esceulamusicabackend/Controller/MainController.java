package com.aln.esceulamusicabackend.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping("/")
    public String index() {
        return "Hi by:Apologix ";
    }

    @RequestMapping("/error")
    public String error() {
        return "An error occurred by:Apologix ";
    }
}
