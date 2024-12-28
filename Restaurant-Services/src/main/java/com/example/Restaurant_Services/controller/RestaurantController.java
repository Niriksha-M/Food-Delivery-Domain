package com.example.Restaurant_Services.controller;

import com.example.Restaurant_Services.entity.RestaurantInfo;
import com.example.Restaurant_Services.service.RestaurantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import java.awt.*;

@RestController
@RequestMapping("/menu")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @PostMapping("/add")
    public RestaurantInfo addMenuItem(@RequestBody @Valid RestaurantInfo restaurantInfo) {
        return restaurantService.addMenuItem(restaurantInfo);
    }

    @GetMapping("/allmenu")
    public List<RestaurantInfo> getAllMenuItems() {
        return restaurantService.getAllMenuItems();
    }
    @GetMapping("/{menuId}")
    public RestaurantInfo getMenuItemById(@PathVariable Long menuId) {
        return restaurantService.getMenuItemById(menuId);
    }
}
