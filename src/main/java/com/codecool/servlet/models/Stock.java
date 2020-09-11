package com.codecool.servlet.models;

import java.util.HashSet;
import java.util.Set;

public class Stock {
    private final Set<Item> itemSet;

    public Stock() {
        itemSet = new HashSet<>();
    }

    public void addToStock(Item item) {
        itemSet.add(item);
    }

    public Set<Item> getItemSet() {
        return itemSet;
    }

    public Item getItemById(int id) {
        return itemSet.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }
}
