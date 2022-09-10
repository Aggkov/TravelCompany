package com.travelcompany.eshop.repository.impl;

import com.travelcompany.eshop.DataBase.DataBase;
import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.repository.ItineraryRepository;
import java.util.List;

public class ItineraryRepositoryImpl implements ItineraryRepository {

    DataBase databaseInstance = DataBase.getInstance();
    List<Itinerary> itineraries = databaseInstance.getItineraries();
    
    @Override
    public List<Itinerary> getAllItineraries() {
        
        return itineraries;
    }

}
