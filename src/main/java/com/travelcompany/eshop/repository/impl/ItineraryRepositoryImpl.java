package com.travelcompany.eshop.repository.impl;

import com.travelcompany.eshop.database.DataBase;
import com.travelcompany.eshop.exception.ResourceNotFoundException;
import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.repository.AbstractRepository;
import com.travelcompany.eshop.repository.ItineraryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class ItineraryRepositoryImpl extends AbstractRepository<Itinerary> implements ItineraryRepository {

    // Turn it to List for queries (GET)
    List<Itinerary> itineraryList = new ArrayList<>(getEntitySet());

    @Override
    protected Set<Itinerary> getEntitySet() {
        return DataBase.getInstance().getItineraries();
    }
    @Override
    public List<Itinerary> getAllItineraries() {
        
        return itineraryList;
    }

    @Override
    public Itinerary findById(Long id) {
        return itineraryList.stream()
                .filter(i -> Objects.equals(i.getId(), id))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException(getEntity() + " with this id was not found"));
    }

}
