package com.cinexpress.videofriend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinexpress.videofriend.models.Customer;
import com.cinexpress.videofriend.models.Movie;
import com.cinexpress.videofriend.services.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("")
    public ResponseEntity<Void> createCustomer(@RequestBody Customer customer) {
        try {
            customerService.createCustomer(customer);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @PostMapping("/addClientToCompany")
    public ResponseEntity<Void> addClientToCompany(Long customerId, Long companyId) {
        try {
            customerService.addClientToCompany(customerId, companyId);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @GetMapping("/listAllCustomerMovies")
    public ResponseEntity<List<Movie>> listAllCustomerMovies(@RequestParam Customer customer) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(customerService.listAllCustomerMovies(customer));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @PostMapping("/alquilarPelicula")
    public ResponseEntity<Void> alquilarPelicula(Long customerId, Long movieId) {
        try {
            customerService.alquilarPelicula(customerId, movieId);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }
    
    


    

    
}
