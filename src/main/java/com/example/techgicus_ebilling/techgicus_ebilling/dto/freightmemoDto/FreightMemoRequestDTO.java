package com.example.techgicus_ebilling.techgicus_ebilling.dto.freightmemoDto;

import java.time.LocalDate;

public class FreightMemoRequestDTO {

    private String billNo;
    private String partyName;
    private String transportname;
    private String vehicleNo;

    private Double loadingWeight;
    private Double unloadingWeight;

    private Double freightRate;

    private Double advanceCash;
    private Double advanceAccount;

    private Double shortageAmount;
    private Double otherdeduction;

    private LocalDate loadingDate;
    private LocalDate unloadingDate;

    public String getBillNo() { return billNo; }
    public void setBillNo(String billNo) { this.billNo = billNo; }

    public String getPartyName() { return partyName; }
    public void setPartyName(String partyName) { this.partyName = partyName; }

    public String getTransportname() { return transportname; }
    public void setTransportname(String transportname) { this.transportname = transportname; }

    public String getVehicleNo() { return vehicleNo; }
    public void setVehicleNo(String vehicleNo) { this.vehicleNo = vehicleNo; }

    public Double getLoadingWeight() { return loadingWeight; }
    public void setLoadingWeight(Double loadingWeight) { this.loadingWeight = loadingWeight; }

    public Double getUnloadingWeight() { return unloadingWeight; }
    public void setUnloadingWeight(Double unloadingWeight) { this.unloadingWeight = unloadingWeight; }

    public Double getFreightRate() { return freightRate; }
    public void setFreightRate(Double freightRate) { this.freightRate = freightRate; }

    public Double getAdvanceCash() { return advanceCash; }
    public void setAdvanceCash(Double advanceCash) { this.advanceCash = advanceCash; }

    public Double getAdvanceAccount() { return advanceAccount; }
    public void setAdvanceAccount(Double advanceAccount) { this.advanceAccount = advanceAccount; }

    public Double getShortageAmount() { return shortageAmount; }
    public void setShortageAmount(Double shortageAmount) { this.shortageAmount = shortageAmount; }

    public Double getOtherdeduction() { return otherdeduction; }
    public void setOtherdeduction(Double otherdeduction) { this.otherdeduction = otherdeduction; }

    public LocalDate getLoadingDate() { return loadingDate; }
    public void setLoadingDate(LocalDate loadingDate) { this.loadingDate = loadingDate; }

    public LocalDate getUnloadingDate() { return unloadingDate; }
    public void setUnloadingDate(LocalDate unloadingDate) { this.unloadingDate = unloadingDate; }
}