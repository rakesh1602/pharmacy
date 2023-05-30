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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pharmacy_contact_entity")
public class PharmacyContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pharmacyContactEntityId;

    private String phoneNumberOne;

    private String phoneNumberTwo;

    @ManyToOne
    @JoinColumn(name = "pharmacy_id")
    private PharmacyEntity pharmacyEntity;
}
