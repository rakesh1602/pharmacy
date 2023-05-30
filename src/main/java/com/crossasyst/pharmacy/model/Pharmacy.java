package com.crossasyst.pharmacy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pharmacy {

    private Long storeNumber;

    private String actions;

    private Date lastActionDateTime;

    private String actionHistory;

    private String system;

    private String systemVersion;

    private Boolean active;

    private List<PharmacyAddress> pharmacyAddressList;

    private List<PharmacyContact> pharmacyContactList;
}
