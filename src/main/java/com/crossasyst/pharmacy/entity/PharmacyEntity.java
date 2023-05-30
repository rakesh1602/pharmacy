package com.crossasyst.pharmacy.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pharmacy_entity")
public class PharmacyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pharmacyId;

    private Long storeNumber;

    private String actions;

    private Date lastActionDateTime;

    private String actionHistory;

    private String system;

    private String systemVersion;

    private Boolean active;

    @OneToMany(mappedBy = "pharmacyEntity", cascade = CascadeType.ALL)
    private List<PharmacyAddressEntity> pharmacyAddressEntity;

    @OneToMany(mappedBy = "pharmacyEntity", cascade = CascadeType.ALL)
    private List<PharmacyContactEntity> pharmacyContactEntity;
}
