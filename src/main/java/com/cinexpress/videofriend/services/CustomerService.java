package com.cinexpress.videofriend.services;

import java.util.List;

import com.cinexpress.videofriend.models.Customer;
import com.cinexpress.videofriend.models.Movie;

public interface CustomerService {
    void createCustomer(Customer customer);
    void addClientToCompany(Long customerId, Long companyId);
    List<Movie> listAllCustomerMovies(Customer customer);
    boolean hasPremiumSubscription(Long customerId);
    void deactivatePremiumSubscription(Long customerId);
    void updateCustomer(Long id, Customer customer);
    void deleteCustomer(Long customerId);
    void alquilarPelicula(Long customerId, Long movieId);
}
