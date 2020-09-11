package com.codecool.servlet.models;

public class Item {
    private static int idCount;
    private final int id;
    private final String name;
    private final double price;

    public Item(String name, double price) {
        this.id = idCount++;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

}
