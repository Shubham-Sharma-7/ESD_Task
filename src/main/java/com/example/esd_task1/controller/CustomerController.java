package com.example.esd_task1.controller;

import com.example.esd_task1.dto.CustomerLoginRequest;
import com.example.esd_task1.dto.CustomerRequest;
import com.example.esd_task1.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<String> greeting() {
        return ResponseEntity.ok("Yummy REST API Customer works");
    }

    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerRequest request) {
        return ResponseEntity.ok(customerService.createCustomer(request));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid CustomerLoginRequest request) {
        return ResponseEntity.ok(customerService.loginCustomer(request));
    }
}
