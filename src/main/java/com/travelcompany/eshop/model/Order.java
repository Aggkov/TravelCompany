package com.travelcompany.eshop.model;

import com.travelcompany.eshop.model.enums.PaymentMethod;

import java.math.BigDecimal;
import java.util.Objects;

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

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Itinerary getItinerary() {
        return itinerary;
    }

    public void setItinerary(Itinerary itinerary) {
        this.itinerary = itinerary;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(passenger, order.passenger) && Objects.equals(itinerary, order.itinerary) && paymentMethod == order.paymentMethod && Objects.equals(paymentAmount, order.paymentAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passenger, itinerary, paymentMethod, paymentAmount);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("Id= ").append(getId());
        sb.append("passenger=").append(passenger);
        sb.append(", itinerary=").append(itinerary);
        sb.append(", paymentMethod=").append(paymentMethod);
        sb.append(", paymentAmount=").append(paymentAmount);
        sb.append('}' + "\n");
        return sb.toString();
    }
}
