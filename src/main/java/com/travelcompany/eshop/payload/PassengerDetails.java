package com.travelcompany.eshop.payload;

import java.math.BigDecimal;

public class PassengerDetails {

    private Integer itineraryCount;

    private BigDecimal totalPaid;

    public PassengerDetails(BigDecimal totalPaid) {
        this.totalPaid = totalPaid;
    }

    public PassengerDetails(Integer itineraryCount, BigDecimal totalPaid) {
        this.itineraryCount = itineraryCount;
        this.totalPaid = totalPaid;
    }

    public Integer getItinaryCount() {
        return itineraryCount;
    }

    public void setItinaryCount(Integer itinaryCount) {
        this.itineraryCount = itinaryCount;
    }

    public BigDecimal getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(BigDecimal totalPaid) {
        this.totalPaid = totalPaid;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PassengerDetails{");
        sb.append("itinaryCount=").append(itineraryCount);
        sb.append(", totalPaid=").append(totalPaid);
        sb.append('}');
        return sb.toString();
    }
}
