package Controller.Persona;

import Data.Person.PersonCreationRequest;
import Model.Person.Address;
import Model.Person.Person;
import Model.Person.User.Users;
import Model.Response.Response;
import Services.CustomOAuth2UserService;
import Services.PersonServices.AddressService;
import Services.PersonServices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @Autowired
    private UserService userService;

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
                 System.out.println("All user info before sending it to the db: "+user.toString());



                 if (addressService.createAddress(address).equals("success") && userService.createUser(user).equals("success")) {
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
            Response<Integer> errorResponse = new Response<>();
            response.setStatus("error");
            response.setTitle("Creation Failed");
            response.setMessage("Creation failed");
            response.setData(0);
            return  response;
        }

    }

    @GetMapping("/test-open")
    public String testOpenEndpoint() {
        return "This is open to everyone!";
    }

}
