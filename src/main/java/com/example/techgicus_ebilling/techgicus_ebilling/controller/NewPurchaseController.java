package com.example.techgicus_ebilling.techgicus_ebilling.controller;


import com.example.techgicus_ebilling.techgicus_ebilling.datamodel.entity.NewPurchase;
import com.example.techgicus_ebilling.techgicus_ebilling.dto.newPurchaseDto.NewPurchaseRequestDTO;
import com.example.techgicus_ebilling.techgicus_ebilling.dto.newPurchaseDto.NewPurchaseResponseDTO;
import com.example.techgicus_ebilling.techgicus_ebilling.service.NewPurchaseService;
import org.hibernate.query.Page;
import org.springdoc.core.converters.models.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PreAuthorize("hasAnyAuthority('ADMIN','SALEEMPLOYEE')")
public class NewPurchaseController {

    @Autowired
    private NewPurchaseService newPurchaseService;


    @PostMapping("/company/new-purchase")
    public ResponseEntity<NewPurchaseResponseDTO> createPurchase(@RequestBody NewPurchaseRequestDTO dto) {
        return ResponseEntity.ok(newPurchaseService.createPurchase(dto));
    }


    @GetMapping("/new-purchase")
    public List<NewPurchaseResponseDTO> getAllPurchase() {
        return newPurchaseService.getAllPurchase();
    }


    @GetMapping("/company/new-purchase/{id}")
    public ResponseEntity<NewPurchaseResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(newPurchaseService.getById(id));
    }


    @PutMapping("/company/new-purchase/{id}")
    public ResponseEntity<NewPurchaseResponseDTO> updatePurchase(
            @PathVariable Long id,
            @RequestBody NewPurchaseRequestDTO dto) {

        return ResponseEntity.ok(newPurchaseService.updatePurchase(id, dto));
    }

    @DeleteMapping("/company/new-purchase/{id}")
    public ResponseEntity<String> deletePurchase(@PathVariable Long id) {

        newPurchaseService.deletePurchase(id);

        return ResponseEntity.ok("Purchase Deleted Successfully");
    }



}
