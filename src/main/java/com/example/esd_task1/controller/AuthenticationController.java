package com.example.esd_task1.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.example.esd_task1.dto.LoginRequest;
import com.example.esd_task1.dto.LoginResponse;
import com.example.esd_task1.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final CustomerService customerService;

    @PostMapping("/customer")
    public ResponseEntity<LoginResponse> loginCustomer(@RequestBody @Valid LoginRequest loginRequest) {
        LoginResponse res = customerService.loginCustomer(loginRequest);
        if (res.authenticated()) return ResponseEntity.ok(res);
        return new ResponseEntity<>(res, HttpStatus.UNAUTHORIZED);
    }
}
