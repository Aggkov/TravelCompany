
package com.travelcompany.eshop.service.impl;

import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.repository.ItineraryRepository;
import com.travelcompany.eshop.repository.impl.ItineraryRepositoryImpl;
import com.travelcompany.eshop.service.ItineraryService;
import java.util.List;

public class ItineraryServiceImpl implements ItineraryService {
    
    ItineraryRepository itineraryRepository = new ItineraryRepositoryImpl();
    
    public List<Itinerary> getAllItineraries() {
        
        return itineraryRepository.getAllItineraries();
    }
    
}
