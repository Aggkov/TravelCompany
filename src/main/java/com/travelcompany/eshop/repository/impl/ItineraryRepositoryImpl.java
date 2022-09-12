package com.travelcompany.eshop.repository.impl;

import com.travelcompany.eshop.DataBase.DataBase;
import com.travelcompany.eshop.exception.ResourceNotFoundException;
import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.repository.ItineraryRepository;
import java.util.List;
import java.util.Objects;

public class ItineraryRepositoryImpl implements ItineraryRepository {

    DataBase databaseInstance = DataBase.getInstance();
    List<Itinerary> itineraries = databaseInstance.getItineraries();
    
    @Override
    public List<Itinerary> getAllItineraries() {
        
        return itineraries;
    }

    @Override
    public Itinerary findById(Long id) {
        return itineraries.stream()
                .filter(i -> Objects.equals(i.getId(), id))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Itinerary with this id was not found"));
    }

}
