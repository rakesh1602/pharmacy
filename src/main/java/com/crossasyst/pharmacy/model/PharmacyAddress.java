package com.crossasyst.pharmacy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PharmacyAddress {

    private String addressLineOne;

    private String addressLineTwo;

    private String city;

    private String state;

    private Integer zipcode;

    private BigDecimal latitude;

    private BigDecimal longitude;
}
