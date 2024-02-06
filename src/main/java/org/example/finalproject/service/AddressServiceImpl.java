package org.example.finalproject.service;

import org.example.finalproject.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.finalproject.repository.AddressRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address save(Address address) {
        Address newAddress = new Address();
        newAddress.setAddressName(address.getAddressName());
        newAddress.setAddressCity(address.getAddressCity());
        return addressRepository.save(newAddress);
    }

    @Override
    public Optional<Address> findAddress(Integer id) {
        return addressRepository.findById(id);
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address update(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public void delete(Integer addressId) {
        addressRepository.deleteById(addressId);
    }
}