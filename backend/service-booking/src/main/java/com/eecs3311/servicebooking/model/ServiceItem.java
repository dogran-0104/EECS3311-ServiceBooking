package com.eecs3311.servicebooking.model;

public class ServiceItem {
    private Long id;
    private String name;
    private int durationMinutes;
    private double price;

    public ServiceItem() {}

    public ServiceItem(Long id, String name, int durationMinutes, double price) {
        this.id = id;
        this.name = name;
        this.durationMinutes = durationMinutes;
        this.price = price;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public int getDurationMinutes() { return durationMinutes; }
    public double getPrice() { return price; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDurationMinutes(int durationMinutes) { this.durationMinutes = durationMinutes; }
    public void setPrice(double price) { this.price = price; }
}

