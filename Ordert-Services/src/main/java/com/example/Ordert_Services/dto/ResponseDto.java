package com.example.Ordert_Services.dto;

import java.util.List;

public class ResponseDto {
    private OrderDto orderDto;
    private List<RestaurantDto> restaurantDto;

    public OrderDto getOrderDto() {
        return orderDto;
    }

    public void setOrderDto(OrderDto orderDto) {
        this.orderDto = orderDto;
    }

    public List<RestaurantDto> getRestaurantDto() {
        return restaurantDto;
    }

    public void setRestaurantDto(List<RestaurantDto> restaurantDto) {
        this.restaurantDto = restaurantDto;
    }
}
