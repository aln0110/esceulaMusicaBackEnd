package Model.Person;

import Model.Person.User.Users;
import lombok.Data;

@Data
public class PersonCreationRequest {
    private Person person;
    private Users user;
    private Address address;

}
