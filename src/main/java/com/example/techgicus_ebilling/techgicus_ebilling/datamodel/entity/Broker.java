package com.example.techgicus_ebilling.techgicus_ebilling.datamodel.entity;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Broker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brokerId;

    private String brokerName;

    @Column(precision = 5, scale = 2)
    private BigDecimal brokerPercent;

    private String saleBillNo;
    private String saleVehicleNo;
    private int saleQty;

    @Column(precision = 12, scale = 2)
    private BigDecimal saleBillTotal;

    @Column(precision = 12, scale = 2)
    private BigDecimal brokerTotal;

    public Long getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(Long brokerId) {
        this.brokerId = brokerId;
    }

    public String getBrokerName() {
        return brokerName;
    }

    public void setBrokerName(String brokerName) {
        this.brokerName = brokerName;
    }

    public BigDecimal getBrokerPercent() {
        return brokerPercent;
    }

    public void setBrokerPercent(BigDecimal brokerPercent) {
        this.brokerPercent = brokerPercent;
    }

    public String getSaleBillNo() {
        return saleBillNo;
    }

    public void setSaleBillNo(String saleBillNo) {
        this.saleBillNo = saleBillNo;
    }

    public String getSaleVehicleNo() {
        return saleVehicleNo;
    }

    public void setSaleVehicleNo(String saleVehicleNo) {
        this.saleVehicleNo = saleVehicleNo;
    }

    public int getSaleQty() {
        return saleQty;
    }

    public void setSaleQty(int saleQty) {
        this.saleQty = saleQty;
    }

    public BigDecimal getSaleBillTotal() {
        return saleBillTotal;
    }

    public void setSaleBillTotal(BigDecimal saleBillTotal) {
        this.saleBillTotal = saleBillTotal;
    }

    public BigDecimal getBrokerTotal() {
        return brokerTotal;
    }

    public void setBrokerTotal(BigDecimal brokerTotal) {
        this.brokerTotal = brokerTotal;
    }
}
