package com.travelcompany.eshop.model;


import com.travelcompany.eshop.model.enums.Category;
import com.travelcompany.eshop.model.enums.Nationality;

public class Passenger extends BaseEntity {

    private String fullName;

    private String email;

    private String address;

    private Nationality nationality;

    private Category category;

    public Passenger(Long id,String fullName, String email,
                     String address, Nationality nationality,
                     Category category) {
        super(id);
        this.fullName = fullName;
        this.email = email;
        this.address = address;
        this.nationality = nationality;
        this.category = category;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Passenger{");
        sb.append(", fullName='").append(fullName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", nationality=").append(nationality);
        sb.append(", category=").append(category);
        sb.append('}');
        return sb.toString();
    }
}
