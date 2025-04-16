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

    @Autowired
    private UserService userServiceS;

    @Autowired
    private AddressService addressService;

    @PostMapping(path = "/create")
    public Response<Boolean> createPerson(@RequestBody PersonCreationRequest request) {
        Person person = request.getPerson();
        Users user = request.getUser();
        Address address = request.getAddress();


        Response<Boolean> res = personService.createPerson(person);
        Response response = new Response();

        if (res.getStatus().equals("success")) {

            Response<Integer> idResponse = personService.getIdPersonByIdCard(person.getIdCard(), person.getTypeIdCard());
             if (idResponse.getStatus().equals("success")) {
                 user.setIdPerson(idResponse.getData());
                 address.setIdPerson(idResponse.getData());
                 BCryptPasswordEncoder passd = new BCryptPasswordEncoder();
                 user.setPassword(passd.encode(user.getPassword()));
                     if (addressService.createAddress(address).getStatus().equals("success") && userServiceS.createUser(user).getStatus().equals("success") ) {
                       return   res;

                     }else{
                         response.setStatus("error");
                         response.setTitle("Creation Failed");
                         response.setMessage("Creation failed could not create user or address");
                         response.setData(0);
                         return  response;
                     }
             }else{
                 response.setStatus("error");
                 response.setTitle("Creation Failed");
                 response.setMessage("Creation failed could not find id");
                 response.setData(0);
                 return  response;
             }
        } else {
            response.setStatus("error");
            response.setTitle("Creation Failed");
            response.setMessage("Creation failed");
            response.setData(0);
            return  response;
        }

    }
    @PutMapping("loDelete/{id}")
    public Response<Boolean> logicalDelete(@PathVariable int id) {
        Response<Boolean> res = personService.logicalDeletePerson(id);
        Response response = new Response();
        if (res.getStatus().equals("success")) {
            response.setStatus("success");
            response.setTitle("Logical Deletion Successful");
            response.setMessage("Logical deletion successful");
            response.setData(res.getData());
            return  response;
        } else {
            response.setStatus("error");
            response.setTitle("Logical Deletion Failed");
            response.setMessage("Logical deletion failed");
            response.setData(0);
            return  response;
        }
  
    }

    @PutMapping("/update")
    public Response<Boolean> updatePerson(@RequestBody Person person) {
        Response<Boolean> res = personService.updatePerson(person);
        Response response = new Response();
        if (res.getStatus().equals("success")) {
            response.setStatus("success");
            response.setTitle("Update Successful");
            response.setMessage("Update successful");
            response.setData(res.getData());
            return  response;
        } else {
            response.setStatus("error");
            response.setTitle("Update Failed");
            response.setMessage("Update failed");
            response.setData(0);
            return  response;
        }
    }

    @GetMapping("get/{id}")
    public Response<Person> getPersonById(@PathVariable int id) {
        Response<Person> res = personService.getPersonById(id);
        Response response = new Response();
        if (res.getStatus().equals("success")) {
            response.setStatus("success");
            response.setTitle("Person Found");
            response.setMessage("Person found successfully");
            response.setData(res.getData());
            return  response;
        } else {
            response.setStatus("error");
            response.setTitle("Person Not Found");
            response.setMessage("Person not found");
            response.setData(0);
            return  response;
        }
    }
    @GetMapping("/getIdCard")
    public Response<Integer> getIdPersonByIdCard(@RequestParam String idCard, @RequestParam String typeIdCard) {
        Response<Integer> res = personService.getIdPersonByIdCard(idCard, typeIdCard);
        Response response = new Response();
        if (res.getStatus().equals("success")) {
            response.setStatus("success");
            response.setTitle("ID Found");
            response.setMessage("ID found successfully");
            response.setData(res.getData());
            return  response;
        } else {
            response.setStatus("error");
            response.setTitle("ID Not Found");
            response.setMessage("ID not found");
            response.setData(0);
            return  response;
        }
    }
    @GetMapping("/getAll")
    public Response<Person> getAllPerson() {
        Response<List<Person>> res = personService.getAllPersons();
        Response response = new Response();
        if (res.getStatus().equals("success")) {
            response.setStatus("success");
            response.setTitle("Persons Found");
            response.setMessage("Persons found successfully");
            response.setData(res.getData());
            return  response;
        } else {
            response.setStatus("error");
            response.setTitle("Persons Not Found");
            response.setMessage("Persons not found");
            response.setData(0);
            return  response;
        }
    }
    



    @GetMapping("/test-open")
    public String testOpenEndpoint() {
        return "This is open to everyone!";
    }

}
