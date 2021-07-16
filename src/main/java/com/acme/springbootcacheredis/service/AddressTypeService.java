package com.acme.springbootcacheredis.service;

import com.acme.springbootcacheredis.entities.AddressType;
import com.acme.springbootcacheredis.exceptions.EntityNotFoundException;
import com.acme.springbootcacheredis.repository.AddressTypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AddressTypeService {

    public static final String CACHE_NAME = "AddressType";

    @Autowired
    private AddressTypeRepository addressTypeRepository;

    @Cacheable(cacheNames = CACHE_NAME, key = "#root.method.name")
    public List<AddressType> findAll() {
        log.info("Call addressTypeRepository.findAll()");
        return addressTypeRepository.findAll();
    }

    @Cacheable(cacheNames = CACHE_NAME, key = "#id")
    public AddressType findById(final Long id) {
        log.info("Call addressTypeRepository.findById(id)");
        return addressTypeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Id not found: " + id));
    }

    @CacheEvict(cacheNames = CACHE_NAME, allEntries = true)
    public AddressType create(final AddressType addressType) {
        log.info("Call addressTypeRepository.save(addressType)");
        return addressTypeRepository.save(addressType);
    }

    @CachePut(cacheNames = CACHE_NAME, key="#addressType.getAddressTypeId()")
    public AddressType update(final AddressType addressType) {
        log.info("Call update addressTypeRepository.save(addressType)");
        if (addressType.getAddressTypeId() == null) {
            throw new EntityNotFoundException("Id is empty");
        }

        return addressTypeRepository.save(addressType);
    }

    @CacheEvict(cacheNames = CACHE_NAME, key = "#id")
    public void delete(final Long id) {
        log.info("Call addressTypeRepository.deleteById(id)");
        if (id == null) {
            throw new EntityNotFoundException("Id is empty");
        }

        addressTypeRepository.deleteById(id);
    }

}
