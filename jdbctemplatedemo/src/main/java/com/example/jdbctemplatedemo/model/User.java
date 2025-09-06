package com.example.jdbctemplatedemo.model;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class User {

    @NotBlank(message = "Please enter the full name")
    private String fullName;
    @NotBlank(message = "Please enter email address")
    @Email(message = "Please enter valid email address")
    private String email;
    private String password;
    private String gender;
    private String hobbies;
    private String dob;
    private String country;
    @Min(value = 10, message = "Mobile number must be 10 digit")
    private String phone;

}