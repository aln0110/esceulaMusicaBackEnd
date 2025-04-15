package Model.Person.User;

import Model.Person.Person;
import Model.Person.Address;

import lombok.Data;


@Data
public class UserProfile {
    private Users user;
    private Person person;
    private Address addresses;

    public UserProfile(Users user, Person person, Address addresses) {
        this.user = user;
        this.person = person;
        this.addresses = addresses;
    }
}