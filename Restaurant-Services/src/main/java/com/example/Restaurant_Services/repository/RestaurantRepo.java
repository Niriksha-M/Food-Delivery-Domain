package com.example.Restaurant_Services.repository;

import com.example.Restaurant_Services.entity.RestaurantInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepo extends JpaRepository<RestaurantInfo,Long> {

}
