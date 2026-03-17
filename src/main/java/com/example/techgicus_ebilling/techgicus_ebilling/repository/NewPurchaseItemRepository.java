package com.example.techgicus_ebilling.techgicus_ebilling.repository;

import com.example.techgicus_ebilling.techgicus_ebilling.datamodel.entity.NewPurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewPurchaseItemRepository extends JpaRepository<NewPurchaseItem, Long> {
}