package com.internship.infosys.service;



import java.util.List;

import com.internship.infosys.model.User;

public interface UserService {

    User getCurrentUser();

    List<User> getAllUsers();

    User getUser(Long id);

    User updateUser(Long id, User user);

    void deleteUser(Long id);

}