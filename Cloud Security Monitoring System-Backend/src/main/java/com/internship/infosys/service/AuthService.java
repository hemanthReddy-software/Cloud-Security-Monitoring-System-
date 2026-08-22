package com.internship.infosys.service;

import com.internship.infosys.dto.LoginRequest;
import com.internship.infosys.dto.LoginResponse;
import com.internship.infosys.dto.RegisterRequest;

public interface AuthService {

    String register(RegisterRequest request);

    LoginResponse login(LoginRequest request);

}