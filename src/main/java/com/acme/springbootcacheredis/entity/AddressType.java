package com.acme.springbootcacheredis.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "AddressType")
@Entity
@Data
public class AddressType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_type_id", nullable = false)
    private Long addressTypeId;

    @Column(name = "description", nullable = false)
    private String description;
}
