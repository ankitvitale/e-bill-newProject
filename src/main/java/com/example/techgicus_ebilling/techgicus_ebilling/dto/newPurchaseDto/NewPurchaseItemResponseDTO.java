package com.example.techgicus_ebilling.techgicus_ebilling.dto.newPurchaseDto;


import java.util.List;

public class NewPurchaseItemResponseDTO {

    private Long itemId;
    private String itemName;

    private List<Double> weights;

    private Double grossWeight;
    private Double deductionRate;
    private Double deductionWeight;
    private Double netWeight;

    private Double rate;
    private Double amount;

    private Double hamali;
    private Double otherDeduction;

    private Double finalAmount;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public List<Double> getWeights() {
        return weights;
    }

    public void setWeights(List<Double> weights) {
        this.weights = weights;
    }

    public Double getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(Double grossWeight) {
        this.grossWeight = grossWeight;
    }

    public Double getDeductionRate() {
        return deductionRate;
    }

    public void setDeductionRate(Double deductionRate) {
        this.deductionRate = deductionRate;
    }

    public Double getDeductionWeight() {
        return deductionWeight;
    }

    public void setDeductionWeight(Double deductionWeight) {
        this.deductionWeight = deductionWeight;
    }

    public Double getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(Double netWeight) {
        this.netWeight = netWeight;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getHamali() {
        return hamali;
    }

    public void setHamali(Double hamali) {
        this.hamali = hamali;
    }

    public Double getOtherDeduction() {
        return otherDeduction;
    }

    public void setOtherDeduction(Double otherDeduction) {
        this.otherDeduction = otherDeduction;
    }

    public Double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(Double finalAmount) {
        this.finalAmount = finalAmount;
    }
}