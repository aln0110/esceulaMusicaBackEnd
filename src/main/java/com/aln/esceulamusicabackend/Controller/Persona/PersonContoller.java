package com.aln.esceulamusicabackend.Controller.Persona;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import com.aln.esceulamusicabackend.Model.Person.Person;
import com.aln.esceulamusicabackend.Model.Person.PersonCreationRequest;
import com.aln.esceulamusicabackend.Model.Person.User.UserDetails;
import com.aln.esceulamusicabackend.Model.Person.User.Users;

import com.aln.esceulamusicabackend.Model.Response.Response;

import com.aln.esceulamusicabackend.Services.PersonServices.PersonService;
import com.aln.esceulamusicabackend.Services.PersonServices.UserService;



@RestController
@RequestMapping("/api/v1/person")
public class PersonContoller {
    @Autowired
    private PersonService personService;

    @Autowired
    private UserService userService;

    @PostMapping(path = "/create")
    public Response<Boolean> createPerson(@RequestBody PersonCreationRequest request) {
        return personService.createPerson(request.getPerson(), request.getUser(), request.getAddress());
    }

    @PutMapping("loDelete/{id}")
    public Response<Boolean> logicalDelete(@PathVariable int id) {
        return personService.logicalDeletePerson(id);
    }

    @PutMapping("/update")
    public Response<Boolean> updatePerson(@RequestBody Person person) {
        return personService.updatePerson(person);
    }

    //@GetMapping("get/{id}")            http://127.0.0.1:8080/api/v1/person/get/2 id if after the get/2 and needs @PathVariable int id
    @GetMapping("get")                  //  http://127.0.0.1:8080/api/v1/person/get?id=2  id if after the get?id=2 and needs @RequestParam int id
    public Response<Person> getPersonById(@RequestParam int id) {
        return personService.getPersonById(id);
    }
    @GetMapping("/getIdCard")
    public Response<Integer> getIdPersonByIdCard(@RequestParam String idCard, @RequestParam String typeIdCard) {
        return personService.getIdPersonByIdCard(idCard, typeIdCard);
    }
    @GetMapping("/getAll")
    public Response<List<Person>> getAllPerson() {
        return personService.getAllPersons();
    }

    @GetMapping("/getDAO")
    public Response<UserDetails> getPersonDetails(@RequestParam int id) {
        return personService.getUserDetailsById(id);
    }
    
    @GetMapping("/test-open")
    public String testOpenEndpoint() {
        return "This is open to everyone!";
    }

    @PostMapping("/login")
    public Response<Users> login(@RequestBody Users loginRequest) {
        return userService.login(loginRequest.getEmail(), loginRequest.getPassword());
    }


}
