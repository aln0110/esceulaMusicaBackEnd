package Controller.Persona;

import Model.Person.Address;
import Model.Person.Person;
import Model.Person.User.Users;
import Model.Response.Response;
import Services.CustomOAuth2UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import  Services.PersonServices.PersonService;

@RestController
@RequestMapping("/api/v1/person")
public class PersonContoller {
    @Autowired
    private PersonService personService;

    @PostMapping(path = "/create")
    public Response<Boolean> createPerson(@RequestBody  Person person) {
        int id = 0;

        Response<Boolean> res = personService.createPerson(person);

        if (res.getStatus().equals("success")) {
            Response<Integer> idResponse = personService.getIdPersonByIdCard(person.getIdCard(), person.getTypeIdCard());
            id = idResponse.getData();
        } else {
            Response<Integer> errorResponse = new Response<>();
            errorResponse.setStatus("error");
            errorResponse.setTitle("Creation Failed");
            errorResponse.setMessage("Could not get ID because creation failed");
            errorResponse.setData(0);
        }

        return res;

    }
    @GetMapping("/test-open")
    public String testOpenEndpoint() {
        return "This is open to everyone!";
    }

}
