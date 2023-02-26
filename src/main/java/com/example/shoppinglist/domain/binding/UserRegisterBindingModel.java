package com.example.shoppinglist.domain.binding;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRegisterBindingModel {

    @NotBlank(message = "username can not be empty")
    @Size(min = 3, max = 20, message = "length must be between 3 and 20 characters")
    private String username;
    @Email
    @NotBlank(message = "email can not be empty")
    private String email;
    @NotBlank(message = "password can not be empty")
    @Size(min = 3, max = 20, message = "length must be between 3 and 20 characters")
    private String password;
    @Size(min = 3, max = 20)
    private String confirmPassword;

    public UserRegisterBindingModel() {
    }


    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
