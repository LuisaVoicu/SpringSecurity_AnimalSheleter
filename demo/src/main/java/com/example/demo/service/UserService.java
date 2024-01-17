package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.model.RegistrationRequest;
import com.example.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    boolean checkEmail(String email);

    UserDto registerUser(RegistrationRequest registrationRequest);

    UserDto getLoginUser();

    UserDto getUserById(Integer id);
    User findUserByID(Integer id);
    List<UserDto> getAllUsers();

    Optional<User> findByUsername(String username);


    UserDto createUser(User user);

    UserDto updateUser(User user);

    void deleteUser(User user);
}