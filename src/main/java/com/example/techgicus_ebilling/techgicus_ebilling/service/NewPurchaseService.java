package com.example.techgicus_ebilling.techgicus_ebilling.service;

import com.example.techgicus_ebilling.techgicus_ebilling.datamodel.entity.*;
import com.example.techgicus_ebilling.techgicus_ebilling.dto.newPurchaseDto.NewPurchaseItemRequestDTO;
import com.example.techgicus_ebilling.techgicus_ebilling.dto.newPurchaseDto.NewPurchaseItemResponseDTO;
import com.example.techgicus_ebilling.techgicus_ebilling.dto.newPurchaseDto.NewPurchaseRequestDTO;
import com.example.techgicus_ebilling.techgicus_ebilling.dto.newPurchaseDto.NewPurchaseResponseDTO;
import com.example.techgicus_ebilling.techgicus_ebilling.repository.CompanyRepository;
import com.example.techgicus_ebilling.techgicus_ebilling.repository.NewPurchaseItemRepository;
import com.example.techgicus_ebilling.techgicus_ebilling.repository.NewPurchaseRepository;
import com.example.techgicus_ebilling.techgicus_ebilling.repository.PartyRepository;
import org.hibernate.query.Page;
import org.springdoc.core.converters.models.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewPurchaseService {

    @Autowired
    private NewPurchaseItemRepository newPurchaseItemRepository;

    @Autowired
    private NewPurchaseRepository newPurchaseRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PartyRepository partyRepository;


    public NewPurchaseResponseDTO createPurchase(NewPurchaseRequestDTO dto) {

        NewPurchase purchase = savePurchase(dto);

        return mapToResponse(purchase);
    }



    public NewPurchaseResponseDTO mapToResponse(NewPurchase purchase) {

        NewPurchaseResponseDTO response = new NewPurchaseResponseDTO();

        response.setPurchaseId(purchase.getNewPurchaseId());
        response.setBillNumber(purchase.getBillNumber());
        response.setPaymentDescription(purchase.getPaymentDescription());
        response.setBillDate(purchase.getBillDate());

        response.setCustomerName(purchase.getCustomerName());
        response.setAddress(purchase.getAddress());
        response.setMobile(purchase.getMobile());
        response.setAdharNo(purchase.getAdharNo());

//        response.setCompanyName(purchase.getCompany().getCompanyName());
//        response.setPartyName(purchase.getParty().getPartyName());

        response.setTotal(purchase.getTotal());

        List<NewPurchaseItemResponseDTO> items = purchase.getItems()
                .stream()
                .map(item -> {

                    NewPurchaseItemResponseDTO dto = new NewPurchaseItemResponseDTO();

                    dto.setItemId(item.getNewPurchaseItemId());
                    dto.setItemName(item.getItemName());

                    dto.setGrossWeight(item.getGrossWeight());
                    dto.setDeductionRate(item.getDeductionRate());
                    dto.setDeductionWeight(item.getDeductionWeight());
                    dto.setNetWeight(item.getNetWeight());

                    dto.setRate(item.getRate());
                    dto.setAmount(item.getAmount());

                    dto.setHamali(item.getHamali());
                    dto.setOtherDeduction(item.getOtherDeduction());

                    dto.setFinalAmount(item.getFinalAmount());

                    List<Double> weights = item.getWeights()
                            .stream()
                            .map(WeightEntry::getWeight)
                            .toList();

                    dto.setWeights(weights);

                    return dto;

                })
                .toList();

        response.setItems(items);

        return response;
    }

    public NewPurchase savePurchase(NewPurchaseRequestDTO dto) {

        Company company = companyRepository.findById(dto.getCompanyId())
                .orElseThrow(() -> new RuntimeException("Company not found"));

        Party party = partyRepository.findById(dto.getPartyId())
                .orElseThrow(() -> new RuntimeException("Party not found"));

        NewPurchase purchase = new NewPurchase();

        purchase.setCompany(company);
        purchase.setParty(party);
        purchase.setBillNumber(dto.getBillNumber());
        purchase.setPaymentDescription(dto.getPaymentDescription());
        purchase.setBillDate(dto.getBillDate());
        purchase.setCustomerName(dto.getCustomerName());
        purchase.setAddress(dto.getAddress());
        purchase.setMobile(dto.getMobile());
        purchase.setAdharNo(dto.getAdharNo());

        List<NewPurchaseItem> itemList = dto.getItems()
                .stream()
                .map(itemDto -> {

                    NewPurchaseItem item = new NewPurchaseItem();

                    item.setItemName(itemDto.getItemName());
                    item.setRate(itemDto.getRate());

                    Double deductionRate = itemDto.getDeductionRate() == null ? 0.0 : itemDto.getDeductionRate();
                    item.setDeductionRate(deductionRate);

                    Double hamali = itemDto.getHamali() == null ? 0.0 : itemDto.getHamali();
                    Double otherDeduction = itemDto.getOtherDeduction() == null ? 0.0 : itemDto.getOtherDeduction();

                    item.setHamali(hamali);
                    item.setOtherDeduction(otherDeduction);

                    double grossWeight = itemDto.getWeights()
                            .stream()
                            .mapToDouble(Double::doubleValue)
                            .sum();

                    double deductionWeight = grossWeight * deductionRate;

                    double netWeight = grossWeight - deductionWeight;

                    double amount = netWeight * itemDto.getRate();

                    double finalAmount = amount - hamali - otherDeduction;

                    item.setGrossWeight(grossWeight);
                    item.setDeductionWeight(deductionWeight);
                    item.setNetWeight(netWeight);
                    item.setAmount(amount);
                    item.setFinalAmount(finalAmount);

                    item.setNewPurchase(purchase);

                    List<WeightEntry> weights = itemDto.getWeights()
                            .stream()
                            .map(w -> {
                                WeightEntry entry = new WeightEntry();
                                entry.setWeight(w);
                                entry.setItem(item);
                                return entry;
                            })
                            .collect(Collectors.toList());

                    item.setWeights(weights);

                    return item;

                })
                .collect(Collectors.toList());

        double totalAmount = itemList.stream()
                .mapToDouble(NewPurchaseItem::getFinalAmount)
                .sum();

        purchase.setItems(itemList);
        purchase.setTotal(totalAmount);

        return newPurchaseRepository.save(purchase);
    }

    public List<NewPurchaseResponseDTO> getAllPurchase() {

        return newPurchaseRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public NewPurchaseResponseDTO getById(Long id) {

        NewPurchase purchase = newPurchaseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Purchase not found"));

        return mapToResponse(purchase);
    }

//    public NewPurchaseResponseDTO updatePurchase(Long id, NewPurchaseRequestDTO dto) {
//
//        NewPurchase purchase = newPurchaseRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Purchase not found"));
//
//        purchase.getItems().clear();
//
//        Company company = companyRepository.findById(dto.getCompanyId())
//                .orElseThrow(() -> new RuntimeException("Company not found"));
//
//        Party party = partyRepository.findById(dto.getPartyId())
//                .orElseThrow(() -> new RuntimeException("Party not found"));
//
//        purchase.setCompany(company);
//        purchase.setParty(party);
//        purchase.setBillNumber(dto.getBillNumber());
//        purchase.setPaymentDescription(dto.getPaymentDescription());
//        purchase.setBillDate(dto.getBillDate());
//        purchase.setCustomerName(dto.getCustomerName());
//        purchase.setAddress(dto.getAddress());
//        purchase.setMobile(dto.getMobile());
//        purchase.setAdharNo(dto.getAdharNo());
//
//        List<NewPurchaseItem> itemList = dto.getItems().stream().map(itemDto -> {
//
//            NewPurchaseItem item = new NewPurchaseItem();
//
//            item.setItemName(itemDto.getItemName());
//            item.setRate(itemDto.getRate());
//
//            Double deductionRate = itemDto.getDeductionRate() == null ? 0.0 : itemDto.getDeductionRate();
//            Double hamali = itemDto.getHamali() == null ? 0.0 : itemDto.getHamali();
//            Double otherDeduction = itemDto.getOtherDeduction() == null ? 0.0 : itemDto.getOtherDeduction();
//
//            double grossWeight = itemDto.getWeights().stream().mapToDouble(Double::doubleValue).sum();
//            double deductionWeight = grossWeight * deductionRate;
//            double netWeight = grossWeight - deductionWeight;
//            double amount = netWeight * itemDto.getRate();
//            double finalAmount = amount - hamali - otherDeduction;
//
//            item.setDeductionRate(deductionRate);
//            item.setHamali(hamali);
//            item.setOtherDeduction(otherDeduction);
//
//            item.setGrossWeight(grossWeight);
//            item.setDeductionWeight(deductionWeight);
//            item.setNetWeight(netWeight);
//            item.setAmount(amount);
//            item.setFinalAmount(finalAmount);
//
//            item.setNewPurchase(purchase);
//
//            List<WeightEntry> weights = itemDto.getWeights().stream().map(w -> {
//                WeightEntry entry = new WeightEntry();
//                entry.setWeight(w);
//                entry.setItem(item);
//                return entry;
//            }).collect(Collectors.toList());
//
//            item.setWeights(weights);
//
//            return item;
//
//        }).collect(Collectors.toList());
//
//        double totalAmount = itemList.stream()
//                .mapToDouble(NewPurchaseItem::getFinalAmount)
//                .sum();
//
//        purchase.setItems(itemList);
//        purchase.setTotal(totalAmount);
//
//        return mapToResponse(newPurchaseRepository.save(purchase));
//    }

    public NewPurchaseResponseDTO updatePurchase(Long id, NewPurchaseRequestDTO dto) {

        NewPurchase purchase = newPurchaseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Purchase not found"));

        Company company = companyRepository.findById(dto.getCompanyId())
                .orElseThrow(() -> new RuntimeException("Company not found"));

        Party party = partyRepository.findById(dto.getPartyId())
                .orElseThrow(() -> new RuntimeException("Party not found"));

        purchase.setCompany(company);
        purchase.setParty(party);
        purchase.setBillNumber(dto.getBillNumber());
        purchase.setPaymentDescription(dto.getPaymentDescription());
        purchase.setBillDate(dto.getBillDate());
        purchase.setCustomerName(dto.getCustomerName());
        purchase.setAddress(dto.getAddress());
        purchase.setMobile(dto.getMobile());
        purchase.setAdharNo(dto.getAdharNo());

        // ✅ IMPORTANT FIX
        purchase.getItems().clear();

        List<NewPurchaseItem> newItems = new ArrayList<>();

        for (NewPurchaseItemRequestDTO itemDto : dto.getItems()) {

            NewPurchaseItem item = new NewPurchaseItem();

            item.setItemName(itemDto.getItemName());
            item.setRate(itemDto.getRate());

            Double deductionRate = itemDto.getDeductionRate() == null ? 0.0 : itemDto.getDeductionRate();
            Double hamali = itemDto.getHamali() == null ? 0.0 : itemDto.getHamali();
            Double otherDeduction = itemDto.getOtherDeduction() == null ? 0.0 : itemDto.getOtherDeduction();

            double grossWeight = itemDto.getWeights().stream().mapToDouble(Double::doubleValue).sum();
            double deductionWeight = grossWeight * deductionRate;
            double netWeight = grossWeight - deductionWeight;
            double amount = netWeight * itemDto.getRate();
            double finalAmount = amount - hamali - otherDeduction;

            item.setDeductionRate(deductionRate);
            item.setHamali(hamali);
            item.setOtherDeduction(otherDeduction);
            item.setGrossWeight(grossWeight);
            item.setDeductionWeight(deductionWeight);
            item.setNetWeight(netWeight);
            item.setAmount(amount);
            item.setFinalAmount(finalAmount);

            // ✅ Set parent
            item.setNewPurchase(purchase);

            List<WeightEntry> weights = itemDto.getWeights().stream().map(w -> {
                WeightEntry entry = new WeightEntry();
                entry.setWeight(w);
                entry.setItem(item);
                return entry;
            }).collect(Collectors.toList());

            item.setWeights(weights);

            newItems.add(item);
        }

        // ✅ DO NOT use setItems()
        purchase.getItems().addAll(newItems);

        double totalAmount = purchase.getItems().stream()
                .mapToDouble(NewPurchaseItem::getFinalAmount)
                .sum();

        purchase.setTotal(totalAmount);

        return mapToResponse(newPurchaseRepository.save(purchase));
    }

    public void deletePurchase(Long id) {

        NewPurchase purchase = newPurchaseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Purchase not found"));

        newPurchaseRepository.delete(purchase);
    }
}
