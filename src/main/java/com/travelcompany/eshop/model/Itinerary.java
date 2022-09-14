package com.travelcompany.eshop.model;

import com.travelcompany.eshop.model.enums.Airline;
import com.travelcompany.eshop.model.enums.DepartureAirportCode;
import com.travelcompany.eshop.model.enums.DestinationAirportCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@EqualsAndHashCode(callSuper = true)
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
