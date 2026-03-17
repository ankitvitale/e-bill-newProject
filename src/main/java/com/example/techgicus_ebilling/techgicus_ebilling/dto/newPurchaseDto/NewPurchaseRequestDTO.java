package com.example.techgicus_ebilling.techgicus_ebilling.dto.newPurchaseDto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


public class NewPurchaseRequestDTO {

    private Long companyId;
    private Long partyId;

    private String billNumber;
    private String paymentDescription;
    private LocalDate billDate;

    private String customerName;
    private String address;
    private String mobile;
    private String adharNo;

    private Double cashAdvance;

    private List<NewPurchaseItemRequestDTO> items;


    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getPartyId() {
        return partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    public String getPaymentDescription() {
        return paymentDescription;
    }

    public void setPaymentDescription(String paymentDescription) {
        this.paymentDescription = paymentDescription;
    }

    public LocalDate getBillDate() {
        return billDate;
    }

    public void setBillDate(LocalDate billDate) {
        this.billDate = billDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAdharNo() {
        return adharNo;
    }

    public void setAdharNo(String adharNo) {
        this.adharNo = adharNo;
    }

    public Double getCashAdvance() {
        return cashAdvance;
    }

    public void setCashAdvance(Double cashAdvance) {
        this.cashAdvance = cashAdvance;
    }

    public List<NewPurchaseItemRequestDTO> getItems() {
        return items;
    }

    public void setItems(List<NewPurchaseItemRequestDTO> items) {
        this.items = items;
    }
}