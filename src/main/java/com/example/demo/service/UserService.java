package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class UserService {

    // Injects the UserRepo bean to interact with the database
    @Autowired
    private UserRepo userRepo;

    // Injects the ModelMapper bean to map between UserDTO and User entities
    @Autowired
    private ModelMapper modelMapper;

    public UserDTO saveUser(UserDTO userDTO){

        // Maps UserDTO to User entity and saves it using the userRepo(userDTO object saves in the database through the repository as User Entity class)
        userRepo.save(modelMapper.map(userDTO, User.class));
        return  userDTO;
    }

    public List<UserDTO> getAllUsers(){

        // Retrieve all User entities from the user repository
        List<User> userList = userRepo.findAll();

        // Map the list of User entities to a list of UserDTO objects using ModelMapper
        return modelMapper.map(userList,new TypeToken<List<UserDTO>>(){}.getType());
    }

    public UserDTO updateUser(UserDTO userDTO){

        // Save the User entity to the repository after mapping from the UserDTO
        userRepo.save(modelMapper.map(userDTO, User.class));

        // Return the same UserDTO object that was passed in
        return userDTO;
    }


    public boolean deleteUser(UserDTO userDTO){

        // Delete the User entity from the repository after mapping from the UserDTO
        userRepo.delete(modelMapper.map(userDTO, User.class));

        // Return true indicating that the delete operation was successful
        return true;
    }


}
