
package com.travelcompany.eshop.service;

import java.util.Optional;

public interface BaseService<T> {
    
    T findByEmail(String email);
    
}
