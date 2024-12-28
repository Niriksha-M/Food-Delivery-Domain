package com.example.Ordert_Services.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
public class OrderInfo {
    @Id
    private int id;

    @NotNull(message = "Menu Item ID is required")
    private Long menuid;

    @Min(value = 1, message = "Quantity must be at least 1")
    private int quantity;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getMenuItemId() {
        return menuid;
    }

    public void setMenuItemId(Long menuid) {
        this.menuid = menuid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
