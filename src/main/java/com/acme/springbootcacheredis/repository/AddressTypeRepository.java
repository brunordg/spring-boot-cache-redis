package com.acme.springbootcacheredis.repository;

import com.acme.springbootcacheredis.entity.AddressType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressTypeRepository extends JpaRepository<AddressType, Long> {
}
