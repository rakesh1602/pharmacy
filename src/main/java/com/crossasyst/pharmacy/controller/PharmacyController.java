package com.crossasyst.pharmacy.controller;

import com.crossasyst.pharmacy.model.Pharmacy;
import com.crossasyst.pharmacy.service.PharmacyService;
import com.crossasyst.pharmacy.entity.PharmacyEntity;
import com.crossasyst.pharmacy.response.PharmacyResponse;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(name = "v1")
public class PharmacyController {

    private final PharmacyService pharmacyService;

    public PharmacyController(PharmacyService pharmacyService) {
        this.pharmacyService = pharmacyService;
    }

    @PostMapping(value = "/pharmacies")
    public ResponseEntity<PharmacyResponse> addPharmacyRecords(@RequestBody Pharmacy pharmacy){
        PharmacyResponse pharmacyResponse=pharmacyService.addPharmacyRecords(pharmacy);
        return new ResponseEntity<>(pharmacyResponse, HttpStatus.OK);
    }

    @GetMapping(path = "/export-csv" )
    public void exportIntoCsv(HttpServletResponse servletResponse) throws IOException{
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=pharmacy.csv");
        pharmacyService.pharmacyCsv(pharmacyService.findAll(),servletResponse.getWriter());
    }
}
