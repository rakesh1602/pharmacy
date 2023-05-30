package com.crossasyst.pharmacy.mapper;

import com.crossasyst.pharmacy.entity.PharmacyEntity;
import com.crossasyst.pharmacy.model.Pharmacy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PharmacyMapper {

    @Mapping(source = "pharmacyAddressList", target = "pharmacyAddressEntity")
    @Mapping(source = "pharmacyContactList", target = "pharmacyContactEntity")
    PharmacyEntity modelToEntity(Pharmacy pharmacy);
}
