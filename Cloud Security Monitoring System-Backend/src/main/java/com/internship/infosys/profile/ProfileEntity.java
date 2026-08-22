package com.internship.infosys.profile;

import java.time.LocalDateTime;

import jakarta.persistence.*;

import com.internship.infosys.model.User;

@Entity
@Table(
    name = "user_profile_data",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uk_profile_user",
            columnNames = "user_id"
        ),
        @UniqueConstraint(
            name = "uk_profile_employee",
            columnNames = "employee_id"
        )
    }
)
public class ProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
        name = "user_id",
        nullable = false,
        unique = true,
        foreignKey = @ForeignKey(
            name = "fk_profile_user"
        )
    )
    private User user;

    @Column(
        name = "employee_id",
        unique = true,
        length = 100
    )
    private String employeeId;

    @Column(length = 100)
    private String name;

    @Column(length = 30)
    private String phone;

    @Column(length = 100)
    private String department;

    @Column(length = 100)
    private String designation;

    @Column(name = "joined_date")
    private LocalDateTime joinedDate;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    @Column(length = 500)
    private String address;

    @Column(length = 2000)
    private String bio;

    @Column(columnDefinition = "TEXT")
    private String avatar;

    @Column(
        nullable = false,
        length = 30
    )
    private String status = "Active";

    public ProfileEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public LocalDateTime getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(LocalDateTime joinedDate) {
        this.joinedDate = joinedDate;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}