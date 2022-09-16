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


    @Override
    protected List<Itinerary> getEntityList() {
        return new ArrayList<>(DataBase.getInstance().getItineraries());
    }
    @Override
    protected Set<Itinerary> getEntitySet() {
        return DataBase.getInstance().getItineraries();
    }


}
