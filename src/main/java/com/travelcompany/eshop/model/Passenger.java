package com.travelcompany.eshop.model;

import com.travelcompany.eshop.model.enums.Authority;
import com.travelcompany.eshop.model.enums.Category;
import com.travelcompany.eshop.model.enums.Nationality;

import java.util.ArrayList;
import java.util.List;

public class Passenger extends BaseEntity {

    private String fullName;

    private String email;

    private String address;

    private Nationality nationality;

    private Category category;

    private Authority authority;

    private List<Itinerary> itineraries;

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
        itineraries = new ArrayList<>();
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
        sb.append('}');
        return sb.toString();
    }
}
