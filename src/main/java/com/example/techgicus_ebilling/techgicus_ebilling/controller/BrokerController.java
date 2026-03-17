package com.example.techgicus_ebilling.techgicus_ebilling.controller;


import com.example.techgicus_ebilling.techgicus_ebilling.dto.BrokerDto.BrokerRequestDTO;
import com.example.techgicus_ebilling.techgicus_ebilling.dto.BrokerDto.BrokerResponseDTO;
import com.example.techgicus_ebilling.techgicus_ebilling.service.BrokerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import java.util.List;

@RestController
    @RequestMapping("/api/broker")
@PreAuthorize("hasAnyAuthority('ADMIN','SALEEMPLOYEE')")
public class BrokerController {

    @Autowired
    private BrokerService brokerService;

    @PostMapping
    public ResponseEntity<BrokerResponseDTO> createBroker(@RequestBody BrokerRequestDTO request){
        BrokerResponseDTO brokerResponseDTO=brokerService.createBroker(request);
        return ResponseEntity.ok(brokerResponseDTO);
    }


    @GetMapping
    public ResponseEntity<Page<BrokerResponseDTO>> getAllBrokers(
            @PageableDefault(page = 0, size = 10) Pageable pageable) {

        return ResponseEntity.ok(brokerService.getAllBrokers(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BrokerResponseDTO> getBrokerById(@PathVariable Long id) {
        return ResponseEntity.ok(brokerService.getBrokerById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BrokerResponseDTO> updateBroker(
            @PathVariable Long id,
            @RequestBody BrokerRequestDTO request) {

        return ResponseEntity.ok(brokerService.updateBroker(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBroker(@PathVariable Long id) {
        return ResponseEntity.ok(brokerService.deleteBroker(id));
    }
}
