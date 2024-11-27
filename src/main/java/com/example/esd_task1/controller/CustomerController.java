package com.example.esd_task1.controller;

import com.example.esd_task1.dto.CustomerResponse;
import com.example.esd_task1.dto.CustomerRequest;
import com.example.esd_task1.dto.CustomerUpdateRequest;
import com.example.esd_task1.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerRequest request) {
        return new ResponseEntity<>(customerService.createCustomer(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<CustomerResponse> getCustomerDetails(@RequestHeader(name = "Authorization", required = false) String authorization) {
        CustomerResponse customerDetails = customerService.getCustomerDetails(authorization);
        return ResponseEntity.ok(customerDetails);
    }

    @PutMapping
    public ResponseEntity<CustomerResponse> updateCustomer(
            @RequestHeader(name = "Authorization", required = false) String authorization,
            @RequestBody @Valid CustomerUpdateRequest request) {
        CustomerResponse updatedCustomerDetails = customerService.updateCustomerDetails(authorization, request);
        return new ResponseEntity<>(updatedCustomerDetails, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteCustomer(@RequestHeader(name = "Authorization", required = false) String authorization) {
        customerService.deleteCustomer(authorization);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
