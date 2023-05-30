package com.crossasyst.pharmacy.service;

import com.crossasyst.pharmacy.entity.PharmacyEntity;
import com.crossasyst.pharmacy.generator.Generators;
import com.crossasyst.pharmacy.mapper.PharmacyMapper;
import com.crossasyst.pharmacy.model.Pharmacy;
import com.crossasyst.pharmacy.repository.PharmacyRepository;
import com.crossasyst.pharmacy.response.PharmacyResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.util.List;

@Service
@Log4j2
public class PharmacyService {

    private final PharmacyMapper pharmacyMapper;

    private final PharmacyRepository pharmacyRepository;

    private final Generators generators;

    @Autowired
    public PharmacyService(PharmacyMapper pharmacyMapper, PharmacyRepository pharmacyRepository, Generators generators) {
        this.pharmacyMapper = pharmacyMapper;
        this.pharmacyRepository = pharmacyRepository;
        this.generators = generators;
    }

    public PharmacyResponse addPharmacyRecords(Pharmacy pharmacy) {
        log.info("Adding pharmacy records");

        PharmacyEntity pharmacyEntity = pharmacyMapper.modelToEntity(pharmacy);

        if (pharmacyEntity.getPharmacyAddressEntity() != null) {
            pharmacyEntity.getPharmacyAddressEntity().forEach(addressEntity -> addressEntity.setPharmacyEntity(pharmacyEntity));
        }

        if (pharmacyEntity.getPharmacyContactEntity() != null) {
            pharmacyEntity.getPharmacyContactEntity().forEach(contactEntity -> contactEntity.setPharmacyEntity(pharmacyEntity));
        }

        pharmacyRepository.save(pharmacyEntity);
        log.info("Pharmacy data saved successfully.");

        PharmacyResponse pharmacyResponse = new PharmacyResponse();
        pharmacyResponse.setPharmacyResponse(pharmacyEntity.getPharmacyId());
        return pharmacyResponse;
    }

    public void pharmacyCsv(List<PharmacyEntity> pharmacyEntityList, PrintWriter writer){
            generators.pharmacyCsv(pharmacyEntityList,writer);
    }

    public List<PharmacyEntity> findAll(){
        return pharmacyRepository.findAll();
    }
}
