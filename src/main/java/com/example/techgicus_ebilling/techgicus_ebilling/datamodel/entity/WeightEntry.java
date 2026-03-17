package com.example.techgicus_ebilling.techgicus_ebilling.datamodel.entity;

import jakarta.persistence.*;

@Entity
public class WeightEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double weight;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private NewPurchaseItem item;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public NewPurchaseItem getItem() {
        return item;
    }

    public void setItem(NewPurchaseItem item) {
        this.item = item;
    }
}