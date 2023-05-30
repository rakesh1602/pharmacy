package com.crossasyst.pharmacy.repository;

import com.crossasyst.pharmacy.entity.PharmacyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmacyRepository extends JpaRepository<PharmacyEntity, Long> {
}
