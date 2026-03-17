package com.example.techgicus_ebilling.techgicus_ebilling.datamodel.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class NewPurchaseItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long newPurchaseItemId;

    private String itemName;

    private Double grossWeight;
    private Double deductionWeight;
    private Double netWeight;

    private Double deductionRate;
    private Double rate;

    private Double amount;

    private Double hamali;
    private Double otherDeduction;

    private Double finalAmount;

    @ManyToOne
    @JoinColumn(name = "purchase_id")
    private NewPurchase newPurchase;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<WeightEntry> weights;

    public Long getNewPurchaseItemId() {
        return newPurchaseItemId;
    }

    public void setNewPurchaseItemId(Long newPurchaseItemId) {
        this.newPurchaseItemId = newPurchaseItemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
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

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(Double netWeight) {
        this.netWeight = netWeight;
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

    public Double getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(Double grossWeight) {
        this.grossWeight = grossWeight;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(Double finalAmount) {
        this.finalAmount = finalAmount;
    }

    public List<WeightEntry> getWeights() {
        return weights;
    }

    public void setWeights(List<WeightEntry> weights) {
        this.weights = weights;
    }

    public NewPurchase getNewPurchase() {
        return newPurchase;
    }

    public void setNewPurchase(NewPurchase newPurchase) {
        this.newPurchase = newPurchase;
    }
}