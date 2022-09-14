package com.travelcompany.eshop.model;

import com.travelcompany.eshop.model.enums.PaymentMethod;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public class Order extends BaseEntity {

    private Passenger passenger;

    private Itinerary itinerary;

    private PaymentMethod paymentMethod;

    private BigDecimal paymentAmount;

    public Order(Long id, Passenger passenger, Itinerary itinerary,
                 PaymentMethod paymentMethod, BigDecimal paymentAmount) {
        super(id);
        this.passenger = passenger;
        this.itinerary = itinerary;
        this.paymentMethod = paymentMethod;
        this.paymentAmount = paymentAmount;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order {");
        sb.append("orderId= ").append(getId() + "\n");
        sb.append("passenger=").append(passenger + "\n") ;
        sb.append(", itinerary=").append(itinerary + "\n");
        sb.append("paymentMethod=").append(paymentMethod + "\n");
        sb.append("paymentAmount=").append(paymentAmount + "\n");
        sb.append('}' + "\n");
        return sb.toString();
    }
}
