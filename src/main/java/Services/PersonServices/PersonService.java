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
        boolean success = personData.addPerson(person);
        Response response = new Response();
        if (success) {
            response.setStatus("success");
            response.setTitle("Person Created");
            response.setMessage("Person created successfully");

        } else {
            response.setStatus("error");
            response.setTitle("Person Creation Failed");
            response.setMessage("Failed to create person");
        }

        return  response;
    }
//
   //  public static int getIdPersonByIdCard(String idCard, String idCardType) {
  //  return personData.getIdPersonByIdCard(idCard, idCardType);
  //  }

}
