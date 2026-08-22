package com.internship.infosys.dto;

import com.internship.infosys.model.Role;

public class LoginResponse {

    private Long id;

    private String token;

    private String username;

    private String email;

    private String department;

    private Role role;

    public LoginResponse() {
    }

    public LoginResponse(Long id,
                         String token,
                         String username,
                         String email,
                         String department,
                         Role role) {

        this.id = id;
        this.token = token;
        this.username = username;
        this.email = email;
        this.department = department;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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