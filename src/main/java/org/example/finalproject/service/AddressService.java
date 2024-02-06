package org.example.finalproject.service;

import org.example.finalproject.model.Address;
import org.example.finalproject.model.Customer;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    Optional<Address> findAddress(Integer addressId);
    List<Address> findAll();
    Address save(Address address);
    Address update(Address address);
//    void delete(Address address);

    void delete(Integer addressId);
}