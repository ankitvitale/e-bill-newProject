package com.example.techgicus_ebilling.techgicus_ebilling.datamodel.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "freight_memo")
public class FreightMemo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String billNo;

    private String partyName;
    private String transportname;

    private String vehicleNo;

    private Double loadingWeight;

    private Double unloadingWeight;

    private Double shortageWeight;

    private Double freightRate;

    private Double freightAmount;

    private Double advanceCash;

    private Double advanceAccount;

    private Double shortageAmount;
    private Double otherdeduction;

    private Double finalAmount;

    private LocalDate unloadingDate;
    private LocalDate loadingDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public Double getLoadingWeight() {
        return loadingWeight;
    }

    public void setLoadingWeight(Double loadingWeight) {
        this.loadingWeight = loadingWeight;
    }

    public Double getUnloadingWeight() {
        return unloadingWeight;
    }

    public void setUnloadingWeight(Double unloadingWeight) {
        this.unloadingWeight = unloadingWeight;
    }

    public Double getShortageWeight() {
        return shortageWeight;
    }

    public void setShortageWeight(Double shortageWeight) {
        this.shortageWeight = shortageWeight;
    }

    public Double getFreightRate() {
        return freightRate;
    }

    public void setFreightRate(Double freightRate) {
        this.freightRate = freightRate;
    }

    public Double getFreightAmount() {
        return freightAmount;
    }

    public void setFreightAmount(Double freightAmount) {
        this.freightAmount = freightAmount;
    }

    public Double getAdvanceCash() {
        return advanceCash;
    }

    public void setAdvanceCash(Double advanceCash) {
        this.advanceCash = advanceCash;
    }

    public Double getAdvanceAccount() {
        return advanceAccount;
    }

    public void setAdvanceAccount(Double advanceAccount) {
        this.advanceAccount = advanceAccount;
    }

    public Double getShortageAmount() {
        return shortageAmount;
    }

    public void setShortageAmount(Double shortageAmount) {
        this.shortageAmount = shortageAmount;
    }

    public Double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(Double finalAmount) {
        this.finalAmount = finalAmount;
    }

    public LocalDate getUnloadingDate() {
        return unloadingDate;
    }

    public void setUnloadingDate(LocalDate unloadingDate) {
        this.unloadingDate = unloadingDate;
    }

    public String getTransportname() {
        return transportname;
    }

    public void setTransportname(String transportname) {
        this.transportname = transportname;
    }

    public Double getOtherdeduction() {
        return otherdeduction;
    }

    public void setOtherdeduction(Double otherdeduction) {
        this.otherdeduction = otherdeduction;
    }

    public LocalDate getLoadingDate() {
        return loadingDate;
    }

    public void setLoadingDate(LocalDate loadingDate) {
        this.loadingDate = loadingDate;
    }
}