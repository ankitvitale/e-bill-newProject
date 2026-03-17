package com.example.techgicus_ebilling.techgicus_ebilling.dto.BrokerDto;

import java.math.BigDecimal;

public class BrokerRequestDTO {

    private String brokerName;
    private BigDecimal brokerPercent;
    private String saleBillNo;
    private String saleVehicleNo;
    private int saleQty;
    private BigDecimal saleBillTotal;

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
}