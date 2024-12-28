package com.example.Restaurant_Services.service;

import com.example.Restaurant_Services.entity.RestaurantInfo;
import com.example.Restaurant_Services.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import java.awt.*;
import java.util.Optional;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepo restaurantRepo;

    public RestaurantInfo addMenuItem(RestaurantInfo restaurantInfo) {
        return restaurantRepo.save(restaurantInfo);
    }

    public List<RestaurantInfo> getAllMenuItems() {
        return restaurantRepo.findAll();
    }

    public RestaurantInfo getMenuItemById(Long menuId) {
        // Retrieve the restaurant menu item from the repository
        Optional<RestaurantInfo> restaurantDto = restaurantRepo.findById(menuId);
        if (restaurantDto.isPresent()) {
            return restaurantDto.get();
        } else {
            throw new RuntimeException("Menu item not found with ID: " + menuId);
        }
    }
}
