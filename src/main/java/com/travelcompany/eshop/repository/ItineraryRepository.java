
package com.travelcompany.eshop.repository;

import com.travelcompany.eshop.model.Itinerary;
import java.util.List;

public interface ItineraryRepository {
    
   List<Itinerary> getAllItineraries();

   Itinerary findById(Long id);
    
}
