package Services.PersonServices;

import Data.Person.Users.UsersData;
import Model.Person.User.Users;
import Model.Response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UsersData usersData;

    public UserService() {
       // System.out.println("UserService is being instantiated WHYYYYYYYYYYYYYYYYYYYYY");
    }

    public Response createUser(Users user) {

        System.out.println("Hoa de desde user service" + user.toString());
        boolean success = usersData.addUser(user);
        Response response = new Response();
        if (success) {
            response.setStatus("success");
            response.setTitle("User Created");
            response.setMessage("User created successfully");

        } else {
            response.setStatus("error");
            response.setTitle("User Creation Failed");
            response.setMessage("Failed to create user");
        }

        return  response;
    }

}
