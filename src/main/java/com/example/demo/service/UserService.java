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
        List<User> userList = userRepo.findAll();
        return modelMapper.map(userList,new TypeToken<List<UserDTO>>(){}.getType());
    }


}