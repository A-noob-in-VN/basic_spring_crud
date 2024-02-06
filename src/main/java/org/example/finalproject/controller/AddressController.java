package org.example.finalproject.controller;

import org.example.finalproject.model.Address;
import org.example.finalproject.model.dto.AddressDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.example.finalproject.service.AddressService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("v1/shopee/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("getAll")
    public String getIndex() {
        return "address";
    }

    @GetMapping("{address_id}")
    public ResponseEntity<Address> findAddress(@PathVariable Integer address_id) {
        Optional<Address> addressOptional = addressService.findAddress(address_id);
        return addressOptional.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Address>> findAll() {
        return ResponseEntity.ok(addressService.findAll());
    }

    @PostMapping
    public ResponseEntity<Address> save(@RequestBody AddressDto addressDto) {
        Address address = new Address(addressDto.getAddressName(), addressDto.getAddressCity());
        return ResponseEntity.ok(addressService.save(address));
    }

    @PutMapping("{address_id}")
    public ResponseEntity<Address> update(@RequestBody AddressDto addressDto, @PathVariable Integer address_id) {
        addressDto.setAddressId(address_id);
        Address address = new Address();
        BeanUtils.copyProperties(addressDto, address);
        return ResponseEntity.ok(addressService.update(address));
    }

    @DeleteMapping("/{address_id}")
    public void delete(@PathVariable Integer address_id) {
        addressService.delete(address_id);
    }
}
