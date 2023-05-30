package com.crossasyst.pharmacy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pharmacy_address_entity")
public class PharmacyAddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pharmacyAddressEntityId;

    private String addressLineOne;

    private String addressLineTwo;

    private String city;

    private String state;

    private Integer zipcode;

    private BigDecimal latitude;

    private BigDecimal longitude;

    @ManyToOne
    @JoinColumn(name = "pharmacy_id")
    private PharmacyEntity pharmacyEntity;
}
