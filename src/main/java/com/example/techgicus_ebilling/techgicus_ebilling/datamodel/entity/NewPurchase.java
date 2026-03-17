package com.example.techgicus_ebilling.techgicus_ebilling.datamodel.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class NewPurchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long newPurchaseId;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "party_id")
    private Party party;

    private String billNumber;

    private String paymentDescription;

    private LocalDate billDate;
    private String customerName;
    private String address;
    private String mobile;
    private String adharNo;
    private Double total;

    @OneToMany(mappedBy = "newPurchase",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<NewPurchaseItem> items = new ArrayList<>();

    public Long getNewPurchaseId() {
        return newPurchaseId;
    }

    public void setNewPurchaseId(Long newPurchaseId) {
        this.newPurchaseId = newPurchaseId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<NewPurchaseItem> getItems() {
        return items;
    }

    public void setItems(List<NewPurchaseItem> items) {
        this.items = items;
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
}