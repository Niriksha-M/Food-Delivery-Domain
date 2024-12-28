package com.example.Ordert_Services.dto;

public class RestaurantDto {

    private Long menuid;
    private String name;
    private double price;

    // Getters and Setters

    public Long getId() {
        return menuid;
    }

    public void setId(Long menuid) {
        this.menuid= menuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

