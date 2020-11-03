package com.lucasdecas.household.domain.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Inventory {

    private Map<Item, Integer> stock;

    public Inventory(Map<Item, Integer> stock){
        this.stock = stock;
    }

    public Map<Item, Integer> getStock() {
        return stock;
    }

    public void registerItem(Item item){
        stock.putIfAbsent(item, 0);
    }

    public void removeItem(Item item){
        stock.remove(item);
    }

    public Integer getItemAmountOnStock(Item item){
        return stock.get(item);
    }

    public void incrementItemCountByAmount(Item item, Integer amount){
        if(!stock.containsKey(item)) {
            registerItem(item);
            incrementItemCountByAmount(item, amount);
        } else {
            stock.put(item, stock.get(item) + amount);
        }
    }

    public void decreaseItemCountByAmount(Item item, Integer amount){
        if(stock.containsKey(item)) {
            Integer amountOnStock = stock.get(item);
            if (amountOnStock < amount){
                throw new IllegalArgumentException();
            }
            stock.put(item, amountOnStock - amount);
        }
    }

    public void incrementItemCountByOne(Item item){
        incrementItemCountByAmount(item, 1);
    }

    public Integer getItemAmountByCategory(ItemCategory category){
        int i = 0;
        for (Map.Entry<Item, Integer> stockItem : stock.entrySet()) {
            if(category.equals(stockItem.getKey().getCategory())) {
                i += stockItem.getValue();
            }
        }
        return i;
    }

    public List<Item> getItemsAmountBelowThreshold(Integer threshold){
        List<Item> itemsNearMinimum = new ArrayList<>();
        for (Map.Entry<Item, Integer> stockItem : stock.entrySet()) {
            if (stockItem.getValue() <= threshold){
                itemsNearMinimum.add(stockItem.getKey());
            }
        }
        return itemsNearMinimum;

    }
}
