package com.aln.esceulamusicabackend.Services.PersonServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aln.esceulamusicabackend.Data.Person.PersonData;
import com.aln.esceulamusicabackend.Data.Person.Users.UsersDetailsDAO;
import com.aln.esceulamusicabackend.Model.Person.Address;
import com.aln.esceulamusicabackend.Model.Person.Person;
import com.aln.esceulamusicabackend.Model.Person.User.UserDetails;
import com.aln.esceulamusicabackend.Model.Person.User.Users;
import com.aln.esceulamusicabackend.Model.Response.Response;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonData personData;

    @Autowired
    private UserService userService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private UsersDetailsDAO daos;

    public Response<Boolean> createPerson(Person person) {

        boolean success = personData.addPerson(person);
        Response<Boolean> response = new Response<>();
        if (success) {
            response.setStatus("success");
            response.setTitle("Person Created");
            response.setMessage("Person created successfully");

        } else {
            response.setStatus("error");
            response.setTitle("Person Creation Failed");
            response.setMessage("Failed to create person");

        }

        return response;
    }

    public Response<Boolean> updatePerson(Person person) {
        boolean success = personData.updatePerson(person);
        Response<Boolean> response = new Response<>();
        if (success) {
            response.setStatus("success");
            response.setTitle("Person Updated");
            response.setMessage("Person updated successfully");
        } else {
            response.setStatus("error");
            response.setTitle("Person Update Failed");
            response.setMessage("Failed to update person");
        }
        return response;
    }

    public Response<Boolean> deletePerson(int id) {
        boolean success = personData.deletePerson(id);
        Response<Boolean> response = new Response<>();

        if (success) {
            response.setStatus("success");
            response.setTitle("Person Deleted");
            response.setMessage("Person deleted successfully");
        } else {
            response.setStatus("error");
            response.setTitle("Person Deletion Failed");
            response.setMessage("Failed to delete person");
        }

        response.setData(success);
        return response;
    }

    public Response<Person> getPersonById(int id) {
        Response<Person> response = new Response<>();
        Person person = personData.getPersonById(id);
        if (person != null) {
            response.setStatus("success");
            response.setTitle("Person Found");
            response.setMessage("Person retrieved successfully");
            response.setData(person);
        } else {
            response.setStatus("error");
            response.setTitle("Person Not Found");
            response.setMessage("No person found with given ID");
            response.setData(null);
        }
        return response;
    }

    public Response<List<Person>> getAllPersons() {
        Response<List<Person>> response = new Response<>();
        try {
            List<Person> persons = personData.getAllPersons();
            if (persons != null && !persons.isEmpty()) {
                response.setStatus("success");
                response.setTitle("Persons Retrieved");
                response.setMessage("All persons retrieved successfully");
                response.setData(persons);
            } else {
                response.setStatus("error");
                response.setTitle("No Persons Found");
                response.setMessage("No persons found in the database");
                response.setData(null);
            }
        } catch (Exception e) {
            response.setStatus("error");
            response.setTitle("Database Error");
            response.setMessage("Error retrieving persons: " + e.getMessage());
            response.setData(null);
        }
        return response;
    }

    public Response<Boolean> logicalDeletePerson(int id) {
        boolean success = personData.logicalDeletePerson(id);
        Response<Boolean> response = new Response<>();
        response.setStatus(success ? "success" : "error");
        response.setTitle(success ? "Person Deleted" : "Person Deletion Failed");
        response.setMessage(success ? "Person logically deleted successfully" : "Failed to logically delete person");
        response.setData(success);
        return response;
    }

    public Response<Integer> getIdPersonByIdCard(String idCard, String idCardType) {
        Response<Integer> response = new Response<>();

        try {
            int id = personData.getIdPersonByIdCard(idCard, idCardType);
            if (id > 0) {
                response.setStatus("success");
                response.setTitle("Person Found");
                response.setMessage("Person retrieved successfully");
                response.setData(id);
            } else {
                response.setStatus("error");
                response.setTitle("Person Not Found");
                response.setMessage("No person found with given ID card");
                response.setData(0);
            }
        } catch (Exception e) {
            response.setStatus("error");
            response.setTitle("Database Error");
            response.setMessage("Error retrieving person: " + e.getMessage());
            response.setData(0);
        }
        return response;
    }

    public Response<Boolean> createPerson(Person person, Users user, Address address) {
        Response<Boolean> response = new Response<>();

        boolean personCreated = personData.addPerson(person);
        if (!personCreated) {
            response.setStatus("error");
            response.setTitle("Person Creation Failed");
            response.setMessage("Failed to create person");
            response.setData(false);
            return response;
        }

        int personId = personData.getIdPersonByIdCard(person.getIdCard(), person.getTypeIdCard());
        if (personId <= 0) {
            response.setStatus("error");
            response.setTitle("Person ID Retrieval Failed");
            response.setMessage("Failed to retrieve person ID");
            response.setData(false);
            return response;
        }

        user.setIdPerson(personId);
        address.setIdPerson(personId);

        boolean userCreated = userService.createUser(user).getStatus().equals("success");
        boolean addressCreated = addressService.createAddress(address).getStatus().equals("success");

        if (userCreated && addressCreated) {
            response.setStatus("success");
            response.setTitle("Creation Successful");
            response.setMessage("Person, User, and Address created successfully");
            response.setData(true);
        } else {
            response.setStatus("error");
            response.setTitle("Creation Failed");
            response.setMessage("Failed to create user or address");
            response.setData(false);
        }

        return response;
    }

    public Response<UserDetails> getUserDetailsById(int userId) {
        Response<UserDetails> response = new Response<>();
        UserDetails userDetails = daos.getUserDetailsById(userId);
        if (userDetails != null) {
            response.setStatus("success");
            response.setTitle("User Details Found");
            response.setMessage("User details retrieved successfully");
            response.setData(userDetails);
        } else {
            response.setStatus("error");
            response.setTitle("User Details Not Found");
            response.setMessage("No user details found with given ID");
            response.setData(null);
        }
        return response;
    }

}
