        package com.aln.esceulamusicabackend.Services.PersonServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aln.esceulamusicabackend.Data.Person.Users.UsersData;
import com.aln.esceulamusicabackend.Model.Person.User.Users;
import com.aln.esceulamusicabackend.Model.Response.Response;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UsersData usersData;

    public UserService() {
       // System.out.println("UserService is being instantiated WHYYYYYYYYYYYYYYYYYYYYY");
    }

    public Response<Boolean> createUser(Users user) {
        boolean success = usersData.addUser(user);
        Response<Boolean> response = new Response<>();
        if (success) {
            response.setStatus("success");
            response.setTitle("User Created");
            response.setMessage("User created successfully");
        } else {
            response.setStatus("error");
            response.setTitle("User Creation Failed");
            response.setMessage("Failed to create user");
        }
        response.setData(success);
        return response;
    }

    public Response<Boolean> logicalDeleteUser(int id) {
        boolean success = usersData.logicalDeleteUser(id);
        Response<Boolean> response = new Response<>();
        if (success) {
            response.setStatus("success");
            response.setTitle("User Deleted");
            response.setMessage("User logically deleted successfully");
        } else {
            response.setStatus("error");
            response.setTitle("User Deletion Failed");
            response.setMessage("Failed to logically delete user");
        }
        response.setData(success);
        return response;
    }

    public Response<Users> getUserById(int id) {
        Users user = usersData.getUserById(id);
        Response<Users> response = new Response<>();
        if (user != null) {
            response.setStatus("success");
            response.setTitle("User Found");
            response.setMessage("User retrieved successfully");
            response.setData(user);
        } else {
            response.setStatus("error");
            response.setTitle("User Not Found");
            response.setMessage("No user found with the given ID");
        }
        return response;
    }

    public Response<List<Users>> getAllUsers() {
        List<Users> users = usersData.getAllUsers();
        Response<List<Users>> response = new Response<>();
        if (users != null && !users.isEmpty()) {
            response.setStatus("success");
            response.setTitle("Users Retrieved");
            response.setMessage("All users retrieved successfully");
            response.setData(users);
        } else {
            response.setStatus("error");
            response.setTitle("No Users Found");
            response.setMessage("No users found in the database");
        }
        return response;
    }

    public Response<Boolean> updateUser(Users user) {
        boolean success = usersData.updateUser(user);
        Response<Boolean> response = new Response<>();
        response.setStatus(success ? "success" : "error");
        response.setTitle(success ? "User Updated" : "User Update Failed");
        response.setMessage(success ? "User updated successfully" : "Failed to update user");
        response.setData(success);
        return response;
    }

    public Response<Users> login(String email, String password) {
        Users user = usersData.getUserByEmail(email);
        Response<Users> response = new Response<>();

        if (user != null && password.equals(user.getPassword())) { // Compare plain text passwords
            response.setStatus("success");
            response.setTitle("Login Successful");
            response.setMessage("User logged in successfully");
            response.setData(user);
        } else {
            response.setStatus("error");
            response.setTitle("Login Failed");
            response.setMessage("Invalid email or password");
        }

        return response;
    }
}
