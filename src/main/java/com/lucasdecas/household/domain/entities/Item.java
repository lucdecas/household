package com.lucasdecas.household.domain.entities;

public class Item{

    private ItemCategory category;
    private String name;

    public Item(ItemCategory category, String name){
        this.category = category;
        this.name = name;
    }

    public ItemCategory getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }
}
