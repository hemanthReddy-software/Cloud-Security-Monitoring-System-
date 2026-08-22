package com.internship.infosys.dto;

import com.internship.infosys.model.Role;

public class RegisterRequest {

    private String username;

    private String email;

    private String password;

    private String department;

    private Role role;

    public RegisterRequest() {
    }

    public RegisterRequest(String username, String email,
                           String password, String department,
                           Role role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.department = department;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}