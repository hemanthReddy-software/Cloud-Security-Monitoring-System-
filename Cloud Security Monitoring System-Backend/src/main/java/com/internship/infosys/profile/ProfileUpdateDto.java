package com.internship.infosys.profile;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ProfileUpdateDto {

    @NotBlank(
        message = "Name is required"
    )
    @Size(
        min = 2,
        max = 100,
        message = "Name must be between 2 and 100 characters"
    )
    private String name;

    @NotBlank(
        message = "Email is required"
    )
    @Email(
        message = "Invalid email address"
    )
    private String email;

    private String phone;

    private String department;

    private String designation;

    @Size(
        max = 500,
        message = "Address cannot exceed 500 characters"
    )
    private String address;

    @Size(
        max = 2000,
        message = "Biography cannot exceed 2000 characters"
    )
    private String bio;

    private String avatar;

    public ProfileUpdateDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}