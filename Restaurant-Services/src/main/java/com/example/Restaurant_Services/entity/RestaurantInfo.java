package com.example.Restaurant_Services.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;


@Entity
public class RestaurantInfo {

    @Id
    private int id;

    @NotBlank(message = "Item name cannot be empty")
    private String name;

    @Positive(message = "Price must be positive")
    private Double price;

    private Boolean available;

    public int getId() {
        return id;
    }

    public void setId(int menuid) {
        this.id = menuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

}
