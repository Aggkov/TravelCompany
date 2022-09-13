package com.travelcompany.eshop.model;

import com.travelcompany.eshop.model.enums.Airline;
import com.travelcompany.eshop.model.enums.DepartureAirportCode;
import com.travelcompany.eshop.model.enums.DestinationAirportCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Itinerary extends BaseEntity {

    private DepartureAirportCode departureAirportCode;

    private DestinationAirportCode destinationAirportCode;

    private LocalDateTime departureDate;

    private Airline airline;

    private BigDecimal basicPrice;

    private List<Passenger> passengers;

    public Itinerary(Long id, DepartureAirportCode departureAirportCode, DestinationAirportCode destinationAirportCode,
            LocalDateTime departureDate, Airline airline,
            BigDecimal basicPrice) {
        super(id);
        this.departureAirportCode = departureAirportCode;
        this.destinationAirportCode = destinationAirportCode;
        this.departureDate = departureDate;
        this.airline = airline;
        this.basicPrice = basicPrice;
        passengers = new ArrayList<>();
    }
    public boolean addPassenger(Passenger passenger) {
        if(!passengers.contains(passenger)) {
            passengers.add(passenger);
            passenger.getItineraries().add(this);
            return true;
        }
        return false;
    }

    public DepartureAirportCode getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(DepartureAirportCode departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public BigDecimal getBasicPrice() {
        return basicPrice;
    }

    public void setBasicPrice(BigDecimal basicPrice) {
        this.basicPrice = basicPrice;
    }

    public DestinationAirportCode getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Itinerary itinerary = (Itinerary) o;
        return departureAirportCode == itinerary.departureAirportCode && Objects.equals(departureDate, itinerary.departureDate) && airline == itinerary.airline && Objects.equals(basicPrice, itinerary.basicPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departureAirportCode, departureDate, airline, basicPrice);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Itinerary{");
        sb.append("Id= ").append(getId());
        sb.append(", departureAirportCode=").append(departureAirportCode);
        sb.append(", departureDate=").append(departureDate);
        sb.append(", airline=").append(airline);
        sb.append(", basicPrice=").append(basicPrice);
        sb.append('}');
        return sb.toString();
    }
}
