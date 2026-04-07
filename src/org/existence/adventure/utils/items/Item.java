package org.existence.adventure.utils.items;

import org.existence.adventure.utils.economy.currency.Cost;

/**
 * Framework class for defining items that can be possessed by a Creature
 */
public class Item {

    /**
     * Internal name of the item
     */
    public final String id;
    /**
     * Display name of the item
     */
    public final String name;
    /**
     * Price to buy the item in a shop
     */
    public final Cost price;
    /**
     * Damage dealt by the item in combat
     */
    public final double damage;

    /**
     * Constructs a new Item object
     * 
     * @param id     Name with which the game internally identifies the item
     * @param name   Display name of the item for the player
     * @param price  Price to buy the item in a shop
     * @param damage Base damage dealt by the item in combat
     */
    public Item(String id, String name, Cost price, double damage) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.damage = damage;
    }

    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Cost getPrice() {
        return price;
    }

    public double getDamage() {
        return damage;
    }

}
