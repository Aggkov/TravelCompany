package com.travelcompany.eshop.model;

import com.travelcompany.eshop.model.enums.Authority;
import com.travelcompany.eshop.model.enums.Category;
import com.travelcompany.eshop.model.enums.Nationality;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true, exclude = {"itineraries","orders"})
public class Passenger extends BaseEntity {

    private String fullName;

    private String email;

    private String address;

    private Nationality nationality;

    private Category category;

    private Authority authority;

    private List<Itinerary> itineraries;

    private Set<Order> orders;

    public Passenger(Long id, String fullName, String email,
            String address, Nationality nationality,
            Category category, Authority authority) {
        super(id);
        this.fullName = fullName;
        this.email = email;
        this.address = address;
        this.nationality = nationality;
        this.category = category;
        this.authority = authority;
        this.itineraries = new ArrayList<>();
        this.orders = new LinkedHashSet<>();
    }

    public boolean addItinerary(Itinerary itinerary) {
        if(!itineraries.contains(itinerary)) {
            itineraries.add(itinerary);
            itinerary.getPassengers().add(this);
            return true;
        }
        return false;
    }

    public boolean addOrder(Order order) {
        if(!orders.contains(order)) {
            orders.add(order);
//            itinerary.getPassengers().add(this);
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Customer ").append(super.getId()).append('\'');
        sb.append("fullName='").append(fullName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", nationality=").append(nationality);
        sb.append(", category=").append(category);
        return sb.toString();
    }
}
