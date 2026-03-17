package com.example.techgicus_ebilling.techgicus_ebilling.service;


import com.example.techgicus_ebilling.techgicus_ebilling.datamodel.entity.Broker;
import com.example.techgicus_ebilling.techgicus_ebilling.dto.BrokerDto.BrokerRequestDTO;
import com.example.techgicus_ebilling.techgicus_ebilling.dto.BrokerDto.BrokerResponseDTO;
import com.example.techgicus_ebilling.techgicus_ebilling.repository.BrokerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class BrokerService {

    @Autowired
    private BrokerRepository brokerRepository;

    public BrokerResponseDTO createBroker(BrokerRequestDTO request) {

        Broker broker = mapToEntity(request);

        Broker saved = brokerRepository.save(broker);

        return mapToResponse(saved);
    }


    public Page<BrokerResponseDTO> getAllBrokers(Pageable pageable) {

        return brokerRepository.findAll(pageable)
                .map(this::mapToResponse);
    }

    public BrokerResponseDTO getBrokerById(Long id) {

        Broker broker = brokerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Broker not found"));

        return mapToResponse(broker);
    }

    public BrokerResponseDTO updateBroker(Long id, BrokerRequestDTO request) {

        Broker broker = brokerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Broker not found"));

        broker.setBrokerName(request.getBrokerName());
        broker.setBrokerPercent(request.getBrokerPercent());
        broker.setSaleBillNo(request.getSaleBillNo());
        broker.setSaleVehicleNo(request.getSaleVehicleNo());
        broker.setSaleQty(request.getSaleQty());
        broker.setSaleBillTotal(request.getSaleBillTotal());

        BigDecimal brokerTotal = request.getSaleBillTotal()
                .multiply(request.getBrokerPercent())
                .divide(new BigDecimal("100"));

        broker.setBrokerTotal(brokerTotal);

        Broker updated = brokerRepository.save(broker);

        return mapToResponse(updated);
    }

    public String deleteBroker(Long id) {

        Broker broker = brokerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Broker not found"));

        brokerRepository.delete(broker);

        return "Broker deleted successfully";
    }

    private Broker mapToEntity(BrokerRequestDTO request) {

        Broker broker = new Broker();

        broker.setBrokerName(request.getBrokerName());
        broker.setBrokerPercent(request.getBrokerPercent());
        broker.setSaleBillNo(request.getSaleBillNo());
        broker.setSaleVehicleNo(request.getSaleVehicleNo());
        broker.setSaleQty(request.getSaleQty());
        broker.setSaleBillTotal(request.getSaleBillTotal());

        BigDecimal brokerTotal = request.getSaleBillTotal()
                .multiply(request.getBrokerPercent())
                .divide(new BigDecimal("100"));

        broker.setBrokerTotal(brokerTotal);

        return broker;
    }

    private BrokerResponseDTO mapToResponse(Broker broker) {

        BrokerResponseDTO response = new BrokerResponseDTO();

        response.setBrokerId(broker.getBrokerId());
        response.setBrokerName(broker.getBrokerName());
        response.setBrokerPercent(broker.getBrokerPercent());
        response.setSaleBillNo(broker.getSaleBillNo());
        response.setSaleVehicleNo(broker.getSaleVehicleNo());
        response.setSaleQty(broker.getSaleQty());
        response.setSaleBillTotal(broker.getSaleBillTotal());
        response.setBrokerTotal(broker.getBrokerTotal());

        return response;
    }
}
