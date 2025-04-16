package Services.PersonServices;

import Data.Person.PersonData;
import Model.Person.Person;
import Model.Response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PersonService {

    @Autowired
    private PersonData personData;

    public Response createPerson(Person person) {

        //System.out.println("Hola desde persona Service Creating person: " + person);
        boolean success = personData.addPerson(person);
        Response response = new Response();
        if (success) {
            response.setStatus("success");
            response.setTitle("Person Created");
            response.setMessage("Person created successfully");
            response.setData(person);

        } else {
            response.setStatus("error");
            response.setTitle("Person Creation Failed");
            response.setMessage("Failed to create person");
            response.setData(null);
        }

        return  response;
    }
    public Response updatePerson(Person person) {
        boolean success = personData.updatePerson(person);
        Response response = new Response();
        if (success) {
            response.setStatus("success");
            response.setTitle("Person Updated");
            response.setMessage("Person updated successfully");
            response.setData(person);
        } else {
            response.setStatus("error");
            response.setTitle("Person Update Failed");
            response.setMessage("Failed to update person");
            response.setData(null);
        }
        return  response;
    }
    public Response deletePerson(int id) {
        boolean success = personData.deletePerson(id);
        Response response = new Response();
        if (success) {
            response.setStatus("success");
            response.setTitle("Person Deleted");
            response.setMessage("Person deleted successfully");
            response.setData(null);
        } else {
            response.setStatus("error");
            response.setTitle("Person Deletion Failed");
            response.setMessage("Failed to delete person");
            response.setData(null);
        }
        return  response;
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
        return  response;
    }

    




    public Response logicalDeletePerson(int id) {
        boolean success = personData.logicalDeletePerson(id);
        Response response = new Response();
        if (success) {
            response.setStatus("success");
            response.setTitle("Person Deleted");
            response.setMessage("Person logically deleted successfully");
            response.setData(null);
        } else {
            response.setStatus("error");
            response.setTitle("Person Deletion Failed");
            response.setMessage("Failed to logically delete person");
            response.setData(null);
        }
        return  response;
    }


    public  Response<Integer> getIdPersonByIdCard(String idCard, String idCardType) {
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




}
