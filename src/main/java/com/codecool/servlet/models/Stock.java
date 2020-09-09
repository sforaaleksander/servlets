package com.codecool.servlet.models;

import java.util.HashSet;
import java.util.Set;

public class Stock {
    private Set<Item> itemSet;

    public Stock() {
        itemSet = new HashSet<>();
    }

    public Set<Item> getItemSet() {
        return itemSet;
    }
}
