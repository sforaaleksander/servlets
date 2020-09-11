package com.codecool.servlet.models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Item> itemList;

    public Cart() {
        itemList = new ArrayList<>();
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void addItem(Item item){
        itemList.add(item);
    }

    public void removeItem(Item item) {
        itemList.remove(item);
    }
}
