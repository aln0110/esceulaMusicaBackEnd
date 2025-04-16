package Controller.Persona;

import Model.Person.Address;
import Model.Person.Person;
import Model.Person.PersonCreationRequest;
import Model.Person.User.Users;
import Model.Response.Response;
import Services.CustomOAuth2UserService;
import Services.PersonServices.AddressService;
import Services.PersonServices.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import  Services.PersonServices.PersonService;



@RestController
@RequestMapping("/api/v1/person")
public class PersonContoller {
    @Autowired
    private PersonService personService;

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
    
    @GetMapping("/test-open")
    public String testOpenEndpoint() {
        return "This is open to everyone!";
    }

}
