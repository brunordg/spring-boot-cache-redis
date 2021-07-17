package com.acme.springbootcacheredis.controller;

import com.acme.springbootcacheredis.entity.AddressType;
import com.acme.springbootcacheredis.service.AddressTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressType")
public class AddressTypeController {

    @Autowired
    private AddressTypeService addressTypeService;

    @PostMapping
    public AddressType create(@RequestBody final AddressType addressType) {
        return addressTypeService.create(addressType);
    }

    @PutMapping
    public AddressType update(@RequestBody final AddressType addressType) {
        return addressTypeService.update(addressType);
    }

    @DeleteMapping
    public void delete(@PathVariable("id") final Long id) {
        addressTypeService.delete(id);
    }

    @GetMapping
    public List<AddressType> findAll() {
        return addressTypeService.findAll();
    }

    @GetMapping("/{id}")
    public AddressType findById(@PathVariable("id") final Long id) {
        return addressTypeService.findById(id);
    }
}
