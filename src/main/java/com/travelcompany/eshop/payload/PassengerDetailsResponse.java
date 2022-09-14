package com.travelcompany.eshop.payload;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PassengerDetailsResponse {

    private Integer itineraryCount;

    private BigDecimal totalPaid;


    public PassengerDetailsResponse(Integer itineraryCount, BigDecimal totalPaid) {
        this.itineraryCount = itineraryCount;
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
