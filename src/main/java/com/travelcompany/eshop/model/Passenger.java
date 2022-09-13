package com.travelcompany.eshop.model;

import com.travelcompany.eshop.model.enums.Authority;
import com.travelcompany.eshop.model.enums.Category;
import com.travelcompany.eshop.model.enums.Nationality;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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

    public Set<Order> getOrders() {
        return orders;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }

    public List<Itinerary> getItineraries() {
        return itineraries;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("fullName='").append(fullName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", nationality=").append(nationality);
        sb.append(", category=").append(category);
        sb.append("itineraries= ").append(itineraries);
        sb.append('}');
        return sb.toString();
    }
}
