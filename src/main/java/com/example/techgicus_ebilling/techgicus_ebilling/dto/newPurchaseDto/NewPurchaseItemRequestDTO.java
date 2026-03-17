package com.example.techgicus_ebilling.techgicus_ebilling.dto.newPurchaseDto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


public class NewPurchaseItemRequestDTO {

    private String itemName;

    private List<Double> weights;

    private Double deductionRate;
    private Double rate;

    private Double hamali;
    private Double otherDeduction;

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

    public Double getDeductionRate() {
        return deductionRate;
    }

    public void setDeductionRate(Double deductionRate) {
        this.deductionRate = deductionRate;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
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
}