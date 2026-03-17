package com.example.techgicus_ebilling.techgicus_ebilling.repository;

import com.example.techgicus_ebilling.techgicus_ebilling.datamodel.entity.NewPurchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewPurchaseRepository extends JpaRepository<NewPurchase, Long> {
}