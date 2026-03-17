package com.example.techgicus_ebilling.techgicus_ebilling.dto.newPurchaseDto;

import lombok.Builder;

import java.time.LocalDate;
import java.util.List;



public class NewPurchaseResponseDTO {

    private Long purchaseId;
    private String billNumber;
    private String paymentDescription;
    private LocalDate billDate;

    private String customerName;
    private String address;
    private String mobile;
    private String adharNo;

    private String companyName;
    private String partyName;

    private Double total;


    private List<NewPurchaseItemResponseDTO> items;

    public Long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<NewPurchaseItemResponseDTO> getItems() {
        return items;
    }

    public void setItems(List<NewPurchaseItemResponseDTO> items) {
        this.items = items;
    }
}