package com.example.Ordert_Services.dto;

public class OrderDto {

    private int id;
    private Long menuItemId;
    private int quantity;
    private String menuItemName; // Name of the food item
    private double totalPrice;  // Calculated total price (price * quantity)

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(Long menuItemId) {
        this.menuItemId = menuItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}

