package com.example.esd_task1.service;

import jakarta.validation.Valid;
import com.example.esd_task1.dto.CustomerLoginRequest;
import com.example.esd_task1.dto.CustomerRequest;
import com.example.esd_task1.entity.Customer;
import com.example.esd_task1.mapper.CustomerMapper;
import com.example.esd_task1.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepo repo;
    private final CustomerMapper mapper;
    public String createCustomer(CustomerRequest request) {
        Customer customer = mapper.toEntity(request);
        repo.save(customer);
        return "Created";
    }

    public String loginCustomer(@Valid CustomerLoginRequest request) {
        Customer customer = repo.findByEmail(request.email());
        if (customer == null || !customer.getPassword().equals(request.password())) {
            return "Invalid email or password";
        }

        return "Login Successful";
    }
}
