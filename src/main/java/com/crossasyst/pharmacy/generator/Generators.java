package com.crossasyst.pharmacy.generator;

import com.crossasyst.pharmacy.entity.PharmacyAddressEntity;
import com.crossasyst.pharmacy.entity.PharmacyContactEntity;
import com.crossasyst.pharmacy.entity.PharmacyEntity;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;

@Component
public class Generators {

    public void pharmacyCsv(List<PharmacyEntity> pharmacyEntityList, Writer writer){
        try {
            List<String> headers = Arrays.asList(
                    "PharmacyId", "StoreNumber", "Actions", "LastActionDateTime", "ActionHistory",
                    "System", "SystemVersion", "Active", "AddressLineOne", "AddressLineTwo", "City", "State",
                    "Zipcode", "PhoneNumberOne", "PhoneNumberTwo");

            CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader(headers.toArray(new String[0]));

            CSVPrinter csvPrinter = new CSVPrinter(writer, csvFormat);

            for(PharmacyEntity pharmacyEntity : pharmacyEntityList){
                List<PharmacyAddressEntity> addressList = pharmacyEntity.getPharmacyAddressEntity();
                List<PharmacyContactEntity> contactList = pharmacyEntity.getPharmacyContactEntity();

                for (PharmacyAddressEntity address : addressList) {
                    for (PharmacyContactEntity contact : contactList) {
                        csvPrinter.printRecord(
                                pharmacyEntity.getPharmacyId(), pharmacyEntity.getStoreNumber(),
                                pharmacyEntity.getActions(), pharmacyEntity.getLastActionDateTime(),
                                pharmacyEntity.getActionHistory(), pharmacyEntity.getSystem(),
                                pharmacyEntity.getSystemVersion(), pharmacyEntity.getActive(),
                                address.getAddressLineOne(), address.getAddressLineTwo(),
                                address.getCity(), address.getState(), address.getZipcode(),
                                contact.getPhoneNumberOne(), contact.getPhoneNumberTwo());
                    }
                }
            }

            csvPrinter.flush();
            csvPrinter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
