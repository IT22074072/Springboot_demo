package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// Base URL for all endpoints in this controller
@RequestMapping(value = "api/v1/user")
@CrossOrigin
public class UserController {

    // Injects the UserService dependency into this controller
    @Autowired
    private UserService userService;

    // Handles HTTP GET requests to the "/getUsers" endpoint
    @GetMapping("/getUsers")

    // Returns a list of UserDTO objects by invoking the userService's getAllUsers method
    public List<UserDTO> getUsers(){
        return userService.getAllUsers();
    }

    // Handles HTTP POST requests to /api/v1/user/saveUser
    @PostMapping("/saveUser")
    // Expects a UserDTO object in the request body and returns a UserDTO object as a response
    public UserDTO  saveUser(@RequestBody UserDTO userDTO){
        // Calls the saveUser method in the UserService class to save the user
        return userService.saveUser(userDTO);
    }


    // Maps HTTP PUT requests to /updateUser to this method
    @PutMapping("/updateUser")
    public UserDTO updateUser(@RequestBody UserDTO userDTO){
        // Calls the updateUser method of the userService with the given UserDTO
        return userService.updateUser(userDTO);
    }

    // Maps HTTP DELETE requests to /deleteUser to this method
    @DeleteMapping("/deleteUser")
    public boolean deleteUser(@RequestBody UserDTO userDTO){

        // Calls the deleteUser method of the userService with the given UserDTO
        return userService.deleteUser(userDTO);
    }


}
