package org.existence.adventure.utils.economy.shopping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.existence.adventure.utils.items.Item;

//TODO: doc comments for shop class
public class Shop {

    private String name;
    private List<Item> stock;

    public Shop(String name, Item... stock) {
        this.name = name;
        this.stock = Arrays.asList(stock);
    }

    public Item addStock(Item item) {
        stock.add(item);
        return item;
    }

    public Item removeStock(int id) {
        Item item = stock.get(id);
        stock.remove(id);
        return item;
    }

    public Item removeStock(String name) {
        List<String> names = new ArrayList<>();

        for (int i = 0; i < stock.size(); i++) {
            names.add(stock.get(i).getName());
        }

        int id = names.indexOf(name);
        Item item = stock.get(id);
        stock.remove(id);
        return item;
    }

    public String getName() {
        return name;
    }

    public List<Item> getStock() {
        return stock;
    }

}
