package com.example.demo.dto;

import lombok.Builder;
import java.util.List;
import java.time.LocalDate;
@Builder
public record UserDto(
        String username,
        List<RoleDto> roles,
        String firstName,
        String lastName,
        String emailAddress) {}
//public class UserDto{
//        private String username;
//        private List<RoleDto> roles;
//        private String firstName;
//        private String lastName;
//        private String emailAddress;
//
//        public UserDto(){
//
//        }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public List<RoleDto> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(List<RoleDto> roles) {
//        this.roles = roles;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getEmailAddress() {
//        return emailAddress;
//    }
//
//    public void setEmailAddress(String emailAddress) {
//        this.emailAddress = emailAddress;
//    }
//}