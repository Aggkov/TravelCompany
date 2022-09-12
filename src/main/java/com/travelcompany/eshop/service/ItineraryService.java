
package com.travelcompany.eshop.service;

import com.travelcompany.eshop.model.Itinerary;
import java.util.List;

public interface ItineraryService {
    
    List<Itinerary> getAllItineraries();

    Itinerary findById(Long id);
    
}
