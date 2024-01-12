package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.model.RegistrationRequest;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;


@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;




    // CREATE
    @GetMapping({"/users/create"})
    public String displayCreateUserForm(@RequestParam(value="registrationSuccess", required = false) String success, Model model) {

        model.addAttribute("title", "Register");
        model.addAttribute("registrationSuccess", success);
        model.addAttribute("user", new RegistrationRequest());

        return "/user/create";
    }

    @PostMapping({"/users/create"})
    public String processCreateUsersForm(@ModelAttribute("user") RegistrationRequest registrationRequest, RedirectAttributes redirectAttributes ) {

        UserDto userDto = userService.registerUser(registrationRequest);

        redirectAttributes.addAttribute("registrationSuccess", "Success");

        return "redirect:/users";

    }


    // RETRIEVE

    @GetMapping("/users")
    public String getUsers(Model model){
        List<UserDto> userDtos = userService.getAllUsers();
        model.addAttribute("title", "Users");
        model.addAttribute("users", userDtos);
        return "users";
    }

    @GetMapping("/users/{id}")
    public UserDto getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }


    // UPDATE


    @GetMapping({"/users/update"})
    public String displayEditUserForm(Model model) {
        model.addAttribute("title", "Edit users");
        model.addAttribute("users", this.userService.getAllUsers());
        return "user/update";
    }


    @GetMapping({"users/update-details"})
    public String displayUserEditDetails(@RequestParam String username, Model model) {
        Optional<User> userOpt = this.userService.findByUsername(username);
        if (userOpt.isEmpty()) {
            model.addAttribute("title", "Invalid Username:" + username);
        } else {
            User user = (User)userOpt.get();
            model.addAttribute("title", user.getUsername() + " Details");
            model.addAttribute("user", user);
        }

        System.out.println("!!!!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        return "user/update-details";
    }

    @PostMapping({"users/update-details"})
    public String processEditUserForm(@ModelAttribute("user") User editedUser, Errors errors, Model model) {
        System.out.println("###############3 aaaaa");
        if (errors.hasErrors()) {
            System.out.println("errr~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            model.addAttribute("title", "Edit User");
            return "user/update-details";
        } else {

            System.out.println("$$$$$$ " + editedUser.getUsername());
            Optional<User> userOpt = userService.findByUsername(editedUser.getUsername());
            System.out.println("not_errr~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   -- " + editedUser.getLastName()+" "+ userOpt.get().getLastName());

            if(!userOpt.isEmpty()) {
//                this.userService.deleteUser(userOpt.get());

                userOpt.get().setFirstName(editedUser.getFirstName());
                userOpt.get().setLastName(editedUser.getLastName());
                userOpt.get().setEmailAddress(editedUser.getEmailAddress());

                System.out.println("not_errr~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   -- " + editedUser.getLastName()+" "+ userOpt.get().getLastName());
                this.userService.updateUser(userOpt.get());

            }
            return "redirect:/users";
        }

    }



    // DELETE
    @GetMapping("/users/delete")
    public String displayDeleteUserForm(Model model) {
        model.addAttribute("title", "Delete User");
        model.addAttribute("users", this.userService.getAllUsers());
        return "user/delete";
    }

    @PostMapping("/users/delete")
    public String processDeleteUserForm(@ModelAttribute("userUsernames") String[] userUsernames) {

        if (userUsernames != null) {

            for(String username : userUsernames){

                Optional<User> userOpt = userService.findByUsername(username);

                if(!userOpt.isEmpty()) {
                    this.userService.deleteUser(userOpt.get());
                }
            }
        }

        return "redirect:/users";
    }

}